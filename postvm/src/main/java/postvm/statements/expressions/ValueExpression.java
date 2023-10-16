package postvm.statements.expressions;

import postvm.*;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;

import java.util.List;

public class ValueExpression extends Expression {
    public final Object value;
    public final int type;

    private ValueExpression(Object value, int type) {
        super(0);
        this.value = value;
        this.type = type;
    }

    private Integer valueVisited = null;

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        if(valueVisited==null) switch (type) {
            case ValueType.CHAR: valueVisited = CharClassInstance.get((char) value); break;
            case ValueType.NUMBER: valueVisited = NumberClassInstance.get((Number) value); break;
            case ValueType.STRING: valueVisited = StringClassInstance.get((String) value); break;
            case ValueType.BOOL: valueVisited = BoolClassInstance.get((boolean) value); break;
            default: valueVisited = VoidClassInstance.INSTANCE.classId; break;
        }

        return new Link(valueVisited);
    }

    @Override
    public void compile(List<Integer> bytes, int prevCaller) {
        switch (type) {
            case ValueType.CHAR:
            case ValueType.NUMBER:
                bytes.add(Opcodes.NUM_STORE);
                bytes.add((int) ((Number) value).byteValue());
                break;

            case ValueType.STRING:
            case ValueType.BOOL:
                bytes.add(Opcodes.BOOL_STORE);
                bytes.add(((boolean) value) ? 1: 0);
                break;
        }
    }

    public static class ValueType {
        public static final int NUMBER = 1;
        public static final int CHAR = 2;
        public static final int STRING = 3;
        public static final int BOOL = 4;
    }

    public static ValueExpression get(Number value) {
        return get(value, ValueType.NUMBER);
    }

    public static ValueExpression get(boolean value) {
        return get(value, ValueType.BOOL);
    }

    public static ValueExpression get(char value) {
        return get(value, ValueType.CHAR);
    }

    public static ValueExpression get(String value) {
        return get(value, ValueType.STRING);
    }

    public static ValueExpression get(Object value, int type) {
        if(CacheManager.cacheExpression.containsKey("value-" + value + type))
            return (ValueExpression) CacheManager.cacheExpression.get("value-" + value + type);

        ValueExpression expression = new ValueExpression(value, type);
        CacheManager.cacheExpression.put("value-" + value + type, expression);

        return expression;
    }
}
