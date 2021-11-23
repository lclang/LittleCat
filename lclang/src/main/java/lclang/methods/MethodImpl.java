package lclang.methods;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.TypeErrorException;
import lclang.statements.Statement;
import lclang.types.Type;

import java.util.List;
import java.util.Map;

public class MethodImpl extends Method {
    private final LCBaseExecutor outExecutor;
    private final Map<String, Type> argsMap;
    private final Statement statement;

    public MethodImpl(LCBaseExecutor outExecutor, Map<String, Type> argsMap, Type returnType, Statement statement) {
        super(outExecutor.root, argsMap.values().toArray(new Type[0]), returnType);
        this.outExecutor = outExecutor;
        this.argsMap = argsMap;
        this.statement = statement;
    }

    @Override
    public Value call(Caller caller, List<Value> args) throws LCLangException {
        LCBaseExecutor executor = new LCBaseExecutor(outExecutor);

        String[] keys = argsMap.keySet().toArray(new String[0]);
        for (int i = 0; i < argsMap.size(); i++) {
            executor.variables.put(keys[i], args.get(i).recreate(caller));
        }

        Value value = statement.visit(new Caller(outExecutor.root,
                statement.line, statement.column), executor);
        if(!returnType.isAccept(value.type))
            throw new TypeErrorException("invalid type of return (excepted "+returnType+
                    ", but returned "+value.type+")", new Caller(outExecutor.root,
                    statement.line, statement.column));

        return value.recreate(caller);
    }
}
