package postvm.methods;

import postvm.Caller;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.classes.PostVMClassInstance;
import postvm.statements.MethodStatement;
import postvm.statements.Statement;
import postvm.types.Type;

public class MethodImpl extends MethodInstance {
    private final PostVMExecutor outExecutor;
    private final MethodStatement.Argument[] argsMap;
    private final Statement statement;
    private final boolean importVariables;

    public MethodImpl(PostVMExecutor outExecutor,
                      MethodStatement.Argument[] argsMap,
                      Type returnType,
                      Statement statement,
                      boolean importVariables) throws LCLangRuntimeException {
        super(MethodStatement.resolveArgs(outExecutor.root, argsMap), returnType);

        this.outExecutor = outExecutor;
        this.argsMap = argsMap;
        this.statement = statement;
        this.importVariables = importVariables;
    }

    @Override
    public int call(int inst, int caller, int[] args) throws LCLangRuntimeException {
        PostVMExecutor executor = new PostVMExecutor(outExecutor, importVariables);
        if(inst != NO_INSTANCE) {
            executor.variables.put("this", inst);
        }

        for (int i = 0; i < args.length; i++) {
            executor.variables.put(argsMap[i].name, args[i]);
        }

        int stmtCaller = Caller.register(executor.root.classId, statement.line, caller);
        PostVMClassInstance value = statement.visit(stmtCaller, executor).get();
        if(!returnType.isAccept(value.prototype.type))
            throw new LCLangTypeErrorException("invalid type of return (excepted "+returnType+
                    ", but returned "+value.prototype.type+")", stmtCaller);

        Caller.unregister(stmtCaller);

        return value.classId;
    }
}
