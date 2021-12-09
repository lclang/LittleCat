package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.ArrayClass;
import lclang.utils.LinkUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ArrayExpression extends Expression {
    public final List<Expression> array;

    public ArrayExpression(List<Expression> array) {
        super(0);
        this.array = array;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor executor) throws LCLangRuntimeException {
        final List<Link> values = LinkUtils.linksFromExpressions(prevCaller, executor, array);
        AtomicReference<ArrayClass> arrayClass = new AtomicReference<>(null);
        return new Link(caller -> {
            if(arrayClass.get()==null) arrayClass.set(new ArrayClass(
                    LinkUtils.classesFromLinks(caller, values)
            ));

            return arrayClass.get();
        }, (setCaller, clazz) -> {
            if(clazz instanceof ArrayClass) {
                ArrayClass otherArray = (ArrayClass) clazz;
                for (int i = 0; i < array.size(); i++) {
                    values.get(i).set.invoke(setCaller, otherArray.get(i));
                }
            }else throw new LCLangTypeErrorException("Value is not array", setCaller);
        }, Link.State.NOTHING);
    }
}
