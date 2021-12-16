package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.statements.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class LinkUtils {
    public static List<Link> linksFromExpressions(Caller caller,
                                                  PostVMExecutor executor,
                                                  List<Expression> expressions) throws LCLangRuntimeException {
        ArrayList<Link> values = new ArrayList<>();
        for (Expression expression : expressions) {
            values.add(expression.visit(caller, executor));
        }

        return values;
    }

    public static List<PostVMClass> classesFromLinks(Caller caller,
                                                     List<Link> values) throws LCLangRuntimeException {
        ArrayList<PostVMClass> classes = new ArrayList<>();
        for (Link expression : values) {
            classes.add(expression.get(caller));
        }

        return classes;
    }
}
