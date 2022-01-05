package postvm.statements;

import postvm.Caller;
import postvm.LinkUtils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.methods.Method;
import postvm.statements.expressions.Expression;
import postvm.types.Type;

import java.util.HashMap;
import java.util.List;

public class ClassStatement {
    public final String name;
    public final NamedTypeStatement classExtends;
    public final List<MethodStatement.Argument> arguments;
    public final List<Statement> init;
    public final List<Expression> extendsArguments;
    public final MethodStatement[] methodStatements;

    public ClassStatement(
            String name,
            NamedTypeStatement extendsClass,
            List<MethodStatement.Argument> arguments,
            List<Statement> init,
            List<Expression> extendsArguments,
            MethodStatement[] methodStatements
    ) {
        this.name = name;
        this.classExtends = extendsClass;
        this.arguments = arguments;
        this.init = init;
        this.extendsArguments = extendsArguments;
        this.methodStatements = methodStatements;
    }

    public void visit(PostVMClass root) throws LCLangRuntimeException {
        PostVMClass clazzAst = new PostVMClass(name, root.path);
        clazzAst.constructor = new Method(
                MethodStatement.resolveArgs(root, arguments),
                new Type(clazzAst)) {

            @Override
            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
                PostVMClass clazz = new PostVMClass(ClassStatement.this.name, root.path) {
                    public HashMap<String, MethodStatement> methods = new HashMap<>();

                    {
                        for(MethodStatement methodStatement: methodStatements) {
                            methods.put(methodStatement.name, methodStatement);
                        }
                    }

                    @Override
                    public PostVMClass loadGlobal(String target) {
                        MethodStatement methodStatement = methods.get(target);
                        if(methodStatement!=null) {
                            return methodStatement.visit(this, true);
                        }

                        return super.loadGlobal(target);
                    }
                };

                clazz.executor.variables.putAll(executor.variables);
                clazz.parents.add(root);

                for (int i = 0; i < arguments.size(); i++) {
                    clazz.executor.variables.put(arguments.get(i).name, args.get(i));
                }

                if(classExtends!=null) {
                    Caller extendsCaller = classExtends.getCaller(root);
                    clazz.extendsClass = classExtends.toType(root).clazz.constructor.call(
                            extendsCaller,
                            LinkUtils.classesFromLinks(caller,
                                    LinkUtils.linksFromExpressions(extendsCaller, clazz.executor, extendsArguments)
                            )
                    );
                }

                for (Statement statement: init) {
                    Caller classCaller = new Caller(this, statement.line);
                    statement.visit(classCaller, clazz.executor).get(classCaller);
                }

                return clazz;
            }
        };

        root.classes.put(name, clazzAst);
    }
}
