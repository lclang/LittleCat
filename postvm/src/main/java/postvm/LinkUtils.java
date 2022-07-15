package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.statements.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class LinkUtils {
    public static Link[] linksFromExpressions(Caller caller,
                                                  PostVMExecutor executor,
                                                  Expression[] expressions) throws LCLangRuntimeException {
        Link[] values = new Link[expressions.length];
        for (int i = 0, l = values.length; i < l; i++) {
            values[i] = expressions[i].visit(caller, executor);
        }

        return values;
    }

    public static int[] classesFromLinks(Link[] values) throws LCLangRuntimeException {
        int[] classes = new int[values.length];
        for (int i = 0, l = classes.length; i < l; i++) {
            classes[i] = values[i].get().classId;
        }

        return classes;
    }
}
