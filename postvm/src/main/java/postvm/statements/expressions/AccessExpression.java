package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangNullPointerException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;

public class AccessExpression extends Expression {
    public final Expression expression;
    public final VariableExpression variable;

    public AccessExpression(Expression expression, VariableExpression variable, int line) {
        super(line);
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Link clazzLink = expression.visit(caller, visitor);
        if(clazzLink.state != Link.State.NOTHING) return clazzLink;

        PostVMClass clazz = clazzLink.get(caller);
        if(clazz==NullClass.INSTANCE) throw new LCLangNullPointerException(caller);

        return variable.visit(caller, clazz.executor);
    }
}
