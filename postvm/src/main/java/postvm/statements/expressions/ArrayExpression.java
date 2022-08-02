package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.LinkUtils;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.PostVMClass;

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
                LinkUtils.classesFromLinks(values)
        ).classId) {

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
