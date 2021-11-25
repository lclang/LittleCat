package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.TypeErrorException;
import lclang.libs.lang.ArrayClass;
import lclang.types.Types;
import lclang.utils.ValueUtils;

import java.util.Arrays;
import java.util.List;

public class ArrayExpression extends Expression {
    public final Expression[] array;

    public ArrayExpression(Expression[] array) {
        super(0);
        this.array = array;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor executor) throws LCLangException {
        final List<Value> values = ValueUtils.valuesFromExpressions(prevCaller, executor, Arrays.asList(array));
        return new Value(Types.ARRAY, caller -> new ArrayClass(
                ValueUtils.classesFromValues(caller, executor, values)
        ), (setCaller, newValue) -> {
            LCClass valueClass = newValue.get.invoke(setCaller);
            if(valueClass instanceof ArrayClass) {
                ArrayClass otherArray = (ArrayClass) valueClass;
                for (int i = 0; i < array.length; i++) {
                    values.get(i).set.invoke(setCaller, otherArray.get(i).asValue());
                }
            }else throw new TypeErrorException("Value is not array", setCaller);
        }, Value.State.NOTHING);
    }
}
