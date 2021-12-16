package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.MethodImpl;
import postvm.statements.MethodStatement;
import postvm.statements.TypeStatement;

import java.util.List;

public class LambdaExpression extends Expression {
    public final List<MethodStatement.Argument> args;
    public final TypeStatement returnType;
    public final Expression expression;

    public LambdaExpression(List<MethodStatement.Argument> args,
                            TypeStatement returnType,
                            Expression expression,
                            int line) {
        super(line);
        this.args = args;
        this.returnType = returnType;
        this.expression = expression;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        return new MethodImpl(visitor, args,
                returnType.toType(visitor.root), expression, true).createLink();
    }
}
