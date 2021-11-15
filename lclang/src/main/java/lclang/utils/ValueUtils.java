package lclang.utils;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.statements.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class ValueUtils {
    public static List<Value> fromExpression(Caller caller,
                                             LCBaseExecutor executor,
                                             List<Expression> expressions) throws LCLangException {
        ArrayList<Value> values = new ArrayList<>();
        for (Expression expression : expressions) {
            values.add(expression.visit(caller, executor));
        }

        return values;
    }
}
