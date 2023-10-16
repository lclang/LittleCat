package postvm.statements.expressions;

import postvm.Link;
import postvm.LinkUtils;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClassInstance;
import postvm.classes.PostVMClassInstance;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayExpression extends Expression {
    public final Expression[] array;

    public ArrayExpression(Expression[] array) {
        super(0);
        this.array = array;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor executor) throws LCLangRuntimeException {
        Link[] values = LinkUtils.linksFromExpressions(prevCaller, executor, array);
        return new Link(new ArrayClassInstance(
                Arrays.stream(
                        LinkUtils.classesFromLinks(values)
                ).boxed().collect(Collectors.toList())
        ).classId, Link.State.NOTHING) {

            @Override
            public void set(int setCaller, int classId) throws LCLangRuntimeException {
                PostVMClassInstance clazz = PostVMClassInstance.instances.get(classId);
                if(clazz instanceof ArrayClassInstance) {
                    ArrayClassInstance otherArray = (ArrayClassInstance) clazz;
                    for (int i = 0; i < values.length; i++) {
                        values[i].set(setCaller, otherArray.get(i));
                    }

                }else throw new LCLangTypeErrorException("Value is not array", setCaller);
            }
        };
    }
}
