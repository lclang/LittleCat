package lclang.methods;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.TypeErrorException;
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
                      boolean importVariables) {
        super(outExecutor.root, MethodStatement.resolveArgs(outExecutor.root, argsMap), returnType);
        this.outExecutor = outExecutor;
        this.argsMap = argsMap;
        this.statement = statement;
        this.importVariables = importVariables;
    }

    @Override
    public Value call(Caller caller, List<Value> args) throws LCLangException {
        LCBaseExecutor executor = new LCBaseExecutor(outExecutor, importVariables);

        for (int i = 0; i < argsMap.size(); i++) {
            MethodStatement.Argument argument = argsMap.get(i);
            executor.variables.put(argument.name, args.get(i).recreate(caller));
        }

        Caller stmtCaller = statement.getCaller(outExecutor.root);
        Value value = statement.visit(stmtCaller, executor);
        if(!returnType.isAccept(value.type))
            throw new TypeErrorException("invalid type of return (excepted "+returnType+
                    ", but returned "+value.type+")", stmtCaller);

        return value.recreate(stmtCaller);
    }
}
