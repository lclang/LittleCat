package lclang.methods;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.LCClass;
import lclang.statements.MethodStatement;
import lclang.statements.Statement;
import lclang.types.Type;

import java.util.List;

public class MethodImpl extends Method {
    private final LCBaseExecutor outExecutor;
    private final List<MethodStatement.Argument> argsMap;
    private final Statement statement;
    private final boolean importVariables;

    public MethodImpl(LCBaseExecutor outExecutor,
                      List<MethodStatement.Argument> argsMap,
                      Type returnType,
                      Statement statement,
                      boolean importVariables) throws LCLangRuntimeException {
        super(outExecutor.root, MethodStatement.resolveArgs(outExecutor.root, argsMap), returnType);
        this.outExecutor = outExecutor;
        this.argsMap = argsMap;
        this.statement = statement;
        this.importVariables = importVariables;
    }

    @Override
    public LCClass call(Caller caller, List<LCClass> args) throws LCLangRuntimeException {
        LCBaseExecutor executor = new LCBaseExecutor(outExecutor, importVariables);

        for (int i = 0; i < argsMap.size(); i++) {
            MethodStatement.Argument argument = argsMap.get(i);
            executor.variables.put(argument.name, args.get(i));
        }

        Caller stmtCaller = statement.getCaller(caller);
        Link value = statement.visit(stmtCaller, executor);
        if(!returnType.isAccept(value.type))
            throw new LCLangTypeErrorException("invalid type of return (excepted "+returnType+
                    ", but returned "+value.type+")", stmtCaller);

        return value.get.invoke(stmtCaller);
    }
}
