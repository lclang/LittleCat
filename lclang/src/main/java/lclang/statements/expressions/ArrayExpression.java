package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.ArrayClass;
import lclang.utils.ValueUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ArrayExpression extends Expression {
    public final List<Expression> array;

    public ArrayExpression(List<Expression> array) {
        super(0);
        this.array = array;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor executor) throws LCLangRuntimeException {
        final List<Value> values = ValueUtils.valuesFromExpressions(prevCaller, executor, array);
        AtomicReference<ArrayClass> arrayClass = new AtomicReference<>(null);
        return new Value(ArrayClass.type, caller -> {
            if(arrayClass.get()==null) arrayClass.set(new ArrayClass(
                    ValueUtils.classesFromValues(caller, values)
            ));

            return arrayClass.get();
        }, (setCaller, clazz) -> {
            if(clazz instanceof ArrayClass) {
                ArrayClass otherArray = (ArrayClass) clazz;
                for (int i = 0; i < array.size(); i++) {
                    values.get(i).set.invoke(setCaller, otherArray.get(i));
                }
            }else throw new LCLangTypeErrorException("Value is not array", setCaller);
        }, Value.State.NOTHING);
    }
}
