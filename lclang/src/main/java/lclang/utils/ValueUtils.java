package lclang.utils;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.exceptions.LCLangException;
import lclang.statements.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class ValueUtils {
    public static List<LCClass> fromExpression(Caller caller,
                                               LCBaseExecutor executor,
                                               List<Expression> expressions) throws LCLangException {
        ArrayList<LCClass> values = new ArrayList<>();
        for (Expression expression : expressions) {
            values.add(expression.visit(caller, executor).get.invoke(caller));
        }

        return values;
    }
}
