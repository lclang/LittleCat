package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.TypeErrorException;
import lclang.libs.lang.ArrayClass;
import lclang.utils.ValueUtils;

import java.util.Arrays;

public class ArrayExpression extends Expression {
    public final Expression[] array;

    public ArrayExpression(Expression[] array) {
        super(0, 0);
        this.array = array;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor executor) throws LCLangException {
        ArrayClass arrayClass = new ArrayClass(ValueUtils.fromExpression(prevCaller, executor, Arrays.asList(array)));

        Value value = arrayClass.asValue();
        value.set = (setCaller, newValue) -> {
            LCClass valueClass = newValue.get.invoke(setCaller);
            if(valueClass instanceof ArrayClass) {
                ArrayClass otherArray = (ArrayClass) valueClass;
                for (int i = 0; i < array.length; i++) {
                    arrayClass.list.get(i).set
                            .invoke(setCaller, otherArray.get(i));
                }
            }else throw new TypeErrorException("Value is not array", setCaller);
        };

        return value;
    }
}
