package lclang.statements;

import lclang.Caller;
import lclang.LCClass;
import lclang.LCRootExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.methods.Method;
import lclang.types.NamedType;
import lclang.types.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassStatement {
    public final String name;
    public final NamedTypeStatement classExtends;
    public final Map<String, TypeStatement> arguments;
    public final List<Statement> init;
    public final MethodStatement[] methodStatements;

    public ClassStatement(
            String name,
            NamedTypeStatement extendsClass,
            Map<String, TypeStatement> arguments,
            List<Statement> init,
            MethodStatement[] methodStatements
    ) {
        this.name = name;
        this.classExtends = extendsClass;
        this.arguments = arguments;
        this.init = init;
        this.methodStatements = methodStatements;
    }

    public void visit(LCRootExecutor root) {
        LCClass clazzAst = new LCClass(name, root.path);

        List<String> argsNames = new ArrayList<>();
        Map<String, Type> argumentsResolved = new HashMap<>();
        for (Map.Entry<String, TypeStatement> entry: arguments.entrySet()) {
            argumentsResolved.put(entry.getKey(), entry.getValue().toType(root));
            argsNames.add(entry.getKey());
        }

        clazzAst.constructor = new Method(root,
                argumentsResolved.values().toArray(new Type[0]),
                new NamedType(clazzAst)) {

            @Override
            public Value call(Caller caller, List<Value> args) throws LCLangException {
                LCClass clazz = new LCClass(name, root.path);
                if(extendsClass!=null) {
                    clazz.extendsClass = classExtends.toType(clazz).clazz;
                    clazz.accept(clazz.extendsClass);
                }

                clazz.executor.variables.putAll(executor.variables);
                clazz.accept(root);

                for(MethodStatement methodStatement: methodStatements) {
                    methodStatement.visit(clazz);
                }

                for (int i = 0; i < arguments.size(); i++) {
                    clazz.executor.variables.put(argsNames.get(i), args.get(i));
                }

                for (Statement statement: statements) {
                    Caller classCaller = new Caller(this, statement.line, statement.column);
                    statement.visit(classCaller, clazz.executor).get.invoke(classCaller);
                }

                return clazz.asValue();
            }
        };

        root.classes.put(name, clazzAst);
    }
}
