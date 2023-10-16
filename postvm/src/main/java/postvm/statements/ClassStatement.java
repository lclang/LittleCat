package postvm.statements;

import postvm.Caller;
import postvm.LinkUtils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.ObjectClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.statements.expressions.Expression;

import java.util.HashMap;
import java.util.List;

public class ClassStatement {
    public final String name;
    public final NamedTypeStatement classExtends;
    public final MethodStatement.Argument[] arguments;
    public final List<Statement> init;
    public final Expression[] extendsArguments;
    public final MethodStatement[] methodStatements;

    public ClassStatement(
            String name,
            NamedTypeStatement extendsClass,
            MethodStatement.Argument[] arguments,
            List<Statement> init,
            Expression[] extendsArguments,
            MethodStatement[] methodStatements
    ) {
        this.name = name;
        this.classExtends = extendsClass;
        this.arguments = arguments;
        this.init = init;
        this.extendsArguments = extendsArguments;
        this.methodStatements = methodStatements;
    }

    public void visit(PostVMClassInstance root) throws LCLangRuntimeException {
        PostVMClassPrototype classPrototype = new PostVMClassPrototype(
                name, null, MethodStatement.resolveArgs(root, arguments)
        ) {
            @Override
            public PostVMClassPrototype getExtendsClass() {
                if(classExtends==null) return ObjectClassInstance.PROTOTYPE;
                return classExtends.toType(root).clazz;
            }

            @Override
            public int createClass(int caller, int[] args) {
                return new PostVMClassInstance(caller, this, root.path, LinkUtils.classesFromLinks(
                        LinkUtils.linksFromExpressions(caller, PostVMClassInstance.instances.get(
                                Caller.instances.get(caller).root
                        ).executor, extendsArguments)
                )) {
                    public final HashMap<String, MethodStatement> methods = new HashMap<>();

                    {
                        parents.add(root);
                        for(MethodStatement methodStatement: methodStatements) {
                            methods.put(methodStatement.name, methodStatement);
                        }

                        for (int i = 0; i < arguments.length; i++) {
                            executor.variables.put(arguments[i].name, args[i]);
                        }

                        for (Statement statement: init) {
                            int classCaller = Caller.register(this.classId, statement.line, caller);
                            statement.visit(classCaller, executor);
                        }
                    }

                    @Override
                    public Integer loadMethod(PostVMClassInstance clazz, String target) {
                        MethodStatement methodStatement = methods.get(target);
                        if(methodStatement!=null) {
                            return methodStatement.visit(this, true);
                        }

                        return super.loadMethod(clazz, target);
                    }
                }.classId;
            }
        };

        root.classes.put(name, classPrototype);

//        PostVMClassPrototype clazzAst = new PostVMClassPrototype(name, );
//        clazzAst.constructor = new Method(
//                new Type(clazzAst)) {
//
//            @Override
//            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
//                PostVMClass clazz = new PostVMClass(ClassStatement.this.name, root.path) {

//                };
//
//                clazz.executor.variables.putAll(executor.variables);
//                clazz.parents.add(root);
//

//
//                if(classExtends!=null) {
//                    Caller extendsCaller = classExtends.getCaller(root);
//                    clazz.extendsClass = classExtends.toType(root).clazz.constructor.call(
//                            extendsCaller,
//                            LinkUtils.classesFromLinks(caller,
//                                    LinkUtils.linksFromExpressions(extendsCaller, clazz.executor, extendsArguments)
//                            )
//                    );
//                }
//
//
//                return clazz;
//            }
//        };
//
    }
}
