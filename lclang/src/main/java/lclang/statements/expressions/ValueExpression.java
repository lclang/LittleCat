package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;

public class ValueExpression extends Expression {
    public final LCClass value;

    public ValueExpression(LCClass value) {
        super(0);
        this.value = value;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return value.createLink();
    }
}
