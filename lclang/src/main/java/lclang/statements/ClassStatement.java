package lclang.statements;

import lclang.Caller;
import lclang.LCRootExecutor;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;
import lclang.methods.Method;
import lclang.statements.expressions.Expression;
import lclang.types.NamedType;
import lclang.utils.LinkUtils;

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

    public void visit(LCRootExecutor root) throws LCLangRuntimeException {
        LCClass clazzAst = new LCClass(name, root.path);

        clazzAst.constructor = new Method(root,
                MethodStatement.resolveArgs(root, arguments),
                new NamedType(clazzAst)) {

            @Override
            public LCClass call(Caller caller, List<LCClass> args) throws LCLangRuntimeException {
                LCClass clazz = new LCClass(ClassStatement.this.name, root.path);

                clazz.globals.put("this", clazz);
                clazz.executor.variables.putAll(executor.variables);
                clazz.accept(root);

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

                    clazz.accept(clazz.extendsClass);
                }

                for(MethodStatement methodStatement: methodStatements) {
                    methodStatement.visit(clazz, true);
                }

                for (Statement statement: init) {
                    Caller classCaller = new Caller(this, statement.line);
                    statement.visit(classCaller, clazz.executor).get.invoke(classCaller);
                }

                return clazz;
            }
        };

        root.classes.put(name, clazzAst);
    }
}
