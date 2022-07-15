package postvm.statements.expressions;

import postvm.*;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.PostVMClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayExpression extends Expression {
    public final Expression[] array;

    public ArrayExpression(Expression[] array) {
        super(0);
        this.array = array;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor executor) throws LCLangRuntimeException {
        Link[] values = LinkUtils.linksFromExpressions(prevCaller, executor, array);
        return new Link(new ArrayClass(
                Arrays.stream(
                        LinkUtils.classesFromLinks(values)
                ).boxed().collect(Collectors.toList())
        ).classId, Link.State.NOTHING) {

            @Override
            public void set(Caller setCaller, int classId) throws LCLangRuntimeException {
                PostVMClass clazz = PostVMClass.instances.get(classId);
                if(clazz instanceof ArrayClass) {
                    ArrayClass otherArray = (ArrayClass) clazz;
                    for (int i = 0; i < values.length; i++) {
                        values[i].set(setCaller, otherArray.get(i));
                    }

                }else throw new LCLangTypeErrorException("Value is not array", setCaller);
            }
        };
    }
}
