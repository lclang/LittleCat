package lclang.types;

import lclang.utils.TypeUtils;
import lclang.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallableType extends Type {
    public final List<Type> args;
    public final Type returnType;

    public CallableType(List<Type> args, Type returnType) {
        super("("+ Utils.joinToString(", ", args, Type::toString)+") -> "+returnType);
        this.args = args;
        this.returnType = returnType;
    }

    public CallableType(List<Type> args) {
        this(args, Types.VOID);
    }

    public CallableType() {
        this(new ArrayList<>());
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

    public static CallableType get(Type... args) {
        List<Type> arguments = new ArrayList<>(Arrays.asList(args));
        Type returnType = arguments.remove(args.length-1);

        return new CallableType(arguments, returnType);
    }
}
