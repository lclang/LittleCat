package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.LinkUtils;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.PostVMClass;

import java.util.List;

public class ArrayExpression extends Expression {
    public final List<Expression> array;

    public ArrayExpression(List<Expression> array) {
        super(0);
        this.array = array;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor executor) throws LCLangRuntimeException {
        List<Link> values = LinkUtils.linksFromExpressions(prevCaller, executor, array);
        return new Link(Link.State.NOTHING) {
            public ArrayClass array;

            @Override
            public PostVMClass get(Caller caller) throws LCLangRuntimeException {
                if(array==null) array = new ArrayClass(
                        LinkUtils.classesFromLinks(caller, values)
                );

                return array;
            }

            @Override
            public void set(Caller setCaller, PostVMClass clazz) throws LCLangRuntimeException {
                if(clazz instanceof ArrayClass) {
                    ArrayClass otherArray = (ArrayClass) clazz;
                    for (int i = 0; i < values.size(); i++) {
                        values.get(i).set(setCaller, otherArray.get(i));
                    }

                }else throw new LCLangTypeErrorException("Value is not array", setCaller);
            }
        };
    }
}
