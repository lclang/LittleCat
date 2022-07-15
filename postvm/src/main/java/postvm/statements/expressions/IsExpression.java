package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.BoolClass;
import postvm.statements.TypeStatement;

public class IsExpression extends Expression {
    public final Expression checkExpression;
    public final TypeStatement type;
    public IsExpression(Expression checkExpression, TypeStatement type) {
        super(0);
        this.checkExpression = checkExpression;
        this.type = type;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        return new Link(BoolClass.get(type.toType(visitor.root)
                .isAccept(checkExpression.visit(prevCaller, visitor).get().prototype.type)));
    }
}
