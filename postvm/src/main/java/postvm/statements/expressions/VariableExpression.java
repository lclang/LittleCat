package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;

public class VariableExpression extends Expression {
    public final String name;

    public VariableExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        return visitor.getVariableClass(prevCaller, name);
    }

//    @Override
//    public List<Byte> compile(Caller prevCaller) {
//        ArrayList<Byte> bytes = new ArrayList<>();
//        bytes.add(Opcodes.GET);
//        bytes.addAll(new ArrayList<>());
//
//        List<Byte>
//        return bytes;
//    }
}
