package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.TypeErrorException;
import lclang.libs.lang.ArrayClass;
import lclang.utils.ValueUtils;

import java.util.List;

public class ArrayExpression extends Expression {
    public final List<Expression> array;

    public ArrayExpression(List<Expression> array, int line, int column) {
        super(line, column);
        this.array = array;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor executor) throws LCLangException {
        Caller caller = getCaller(prevCaller);
        ArrayClass arrayClass = new ArrayClass(ValueUtils.fromExpression(caller, executor, array));

        Value value = arrayClass.asValue();
        value.set = (setCaller, newValue) -> {
            LCClass valueClass = newValue.get.invoke(setCaller);
            if(valueClass instanceof ArrayClass) {
                ArrayClass otherArray = (ArrayClass) valueClass;
                for (int i = 0; i < array.size(); i++) {
                    arrayClass.list.get(i).set
                            .invoke(setCaller, otherArray.get(i));
                }
            }else throw new TypeErrorException("Value is not array", setCaller);
        };

        return value;
    }
}
