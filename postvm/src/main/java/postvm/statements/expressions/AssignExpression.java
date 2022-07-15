package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.Opcodes;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;

import java.util.List;

public class AssignExpression extends Expression {
    public final Expression left;
    public final Expression right;

    public AssignExpression(Expression left, Expression right) {
        super(0);
        this.left = left;
        this.right = right;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Link value = right.visit(prevCaller, visitor);
        left.visit(prevCaller, visitor).set(prevCaller, value.classId);
        return value;
    }

    @Override
    public void compile(List<Integer> bytes, Caller prevCaller) {
        right.compile(bytes, prevCaller);
        left.compile(bytes, prevCaller);
        bytes.add(Opcodes.SET);
    }
}
