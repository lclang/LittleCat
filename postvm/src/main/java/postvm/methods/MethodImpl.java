package postvm.methods;

import postvm.Caller;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.PostVMClass;
import postvm.statements.MethodStatement;
import postvm.statements.Statement;
import postvm.types.Type;

import java.util.List;

public class MethodImpl extends Method {
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
    public int call(Caller caller, Integer[] args) throws LCLangRuntimeException {
        PostVMExecutor executor = new PostVMExecutor(outExecutor, importVariables);
        for (int i = 0; i < args.length; i++) {
            executor.variables.put(argsMap[i].name, args[i]);
        }

        Caller stmtCaller = statement.getCaller(caller);
        stmtCaller.root = executor.root;

        PostVMClass value = statement.visit(stmtCaller, executor).get();
        if(!returnType.isAccept(value.prototype.type))
            throw new LCLangTypeErrorException("invalid type of return (excepted "+returnType+
                    ", but returned "+value.prototype.type+")", stmtCaller);

        return value.classId;
    }
}
