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
    private final List<MethodStatement.Argument> argsMap;
    private final Statement statement;
    private final boolean importVariables;

    public MethodImpl(PostVMExecutor outExecutor,
                      List<MethodStatement.Argument> argsMap,
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
    public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
        PostVMExecutor executor = new PostVMExecutor(outExecutor, importVariables);

        for (int i = 0; i < argsMap.size(); i++) {
            MethodStatement.Argument argument = argsMap.get(i);
            executor.variables.put(argument.name, args.get(i));
        }

        Caller stmtCaller = statement.getCaller(caller);
        PostVMClass value = statement.visit(stmtCaller, executor).get(stmtCaller);
        if(!returnType.isAccept(value.classType))
            throw new LCLangTypeErrorException("invalid type of return (excepted "+returnType+
                    ", but returned "+value.classType+")", stmtCaller);

        return value;
    }
}
