package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.LCLangNullPointerException;
import lclang.libs.lang.NullClass;

public class AccessExpression extends Expression {
    public final Expression expression;
    public final VariableExpression variable;

    public AccessExpression(Expression expression, VariableExpression variable, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Caller caller = getCaller(prevCaller);
        LCClass value = expression.visit(caller, visitor).get.invoke(caller);
        if(value==NullClass.NULL) throw new LCLangNullPointerException(expression, caller);

        return variable.visit(caller, value.executor);
    }
}
