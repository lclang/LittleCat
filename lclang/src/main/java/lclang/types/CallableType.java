package lclang.types;

import lclang.utils.TypeUtils;
import lclang.utils.Utils;

import java.util.Arrays;

public class CallableType extends Type {
    public final Type[] args;
    public final Type returnType;

    public CallableType(Type[] args, Type returnType) {
        super("("+ Utils.joinToString(", ", Arrays.asList(args), Type::toString)+") -> "+returnType);
        this.args = args;
        this.returnType = returnType;
    }

    public CallableType(Type[] args) {
        this(args, Types.VOID);
    }

    public CallableType() {
        this(new Type[0]);
    }

    @Override
    public boolean isAcceptWithoutNullable(Type another) {
        if(another == Types.CALLABLE) return true;
        boolean result = super.isAcceptWithoutNullable(another);
        if(result||another instanceof CallableType){
            CallableType anotherCallableType = (CallableType) another;
            result = TypeUtils.isAccept(args, anotherCallableType.args)==-1 &&
                    returnType.isAccept(anotherCallableType.returnType);
        }

        return result;
    }
}
