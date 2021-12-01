package lclang.utils;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.statements.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class ValueUtils {
    public static List<Value> valuesFromExpressions(Caller caller,
                                                    LCBaseExecutor executor,
                                                    List<Expression> expressions) throws LCLangRuntimeException {
        ArrayList<Value> values = new ArrayList<>();
        for (Expression expression : expressions) {
            values.add(expression.visit(caller, executor));
        }

        return values;
    }

    public static List<LCClass> classesFromValues(Caller caller,
                                                  List<Value> values) throws LCLangRuntimeException {
        ArrayList<LCClass> classes = new ArrayList<>();
        for (Value expression : values) {
            classes.add(expression.get.invoke(caller));
        }

        return classes;
    }
}
