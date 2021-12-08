package lclang.utils;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;
import lclang.statements.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class ValueUtils {
    public static List<Link> valuesFromExpressions(Caller caller,
                                                   LCBaseExecutor executor,
                                                   List<Expression> expressions) throws LCLangRuntimeException {
        ArrayList<Link> values = new ArrayList<>();
        for (Expression expression : expressions) {
            values.add(expression.visit(caller, executor));
        }

        return values;
    }

    public static List<LCClass> classesFromValues(Caller caller,
                                                  List<Link> values) throws LCLangRuntimeException {
        ArrayList<LCClass> classes = new ArrayList<>();
        for (Link expression : values) {
            classes.add(expression.get.invoke(caller));
        }

        return classes;
    }
}
