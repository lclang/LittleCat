package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;

public class VariableExpression extends Expression {
    public final String name;

    public VariableExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return visitor.getLink(getCaller(prevCaller), name);
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
