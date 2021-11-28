package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangNullPointerException;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.NullClass;

public class AccessExpression extends Expression {
    public final Expression expression;
    public final VariableExpression variable;

    public AccessExpression(Expression expression, VariableExpression variable, int line) {
        super(line);
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        LCClass value = expression.visit(caller, visitor).get.invoke(caller);
        if(value==NullClass.instance) throw new LCLangNullPointerException(caller);

        return variable.visit(caller, value.executor);
    }
}
