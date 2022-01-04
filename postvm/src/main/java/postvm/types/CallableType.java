package postvm.types;

import postvm.TypeUtils;
import postvm.Utils;
import postvm.methods.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallableType extends Type {
    public final List<Type> args;
    public final Type returnType;

    public CallableType(List<Type> args, Type returnType) {
        super(Method.INSTANCE);
        this.args = args;
        this.returnType = returnType;
    }

    @Override
    public boolean isAcceptWithoutNullable(Type another) {
        if(another == Method.type) return true;
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

    @Override
    public String toString() {
        return "("+ Utils.joinToString(", ", args, Type::toString)+") -> "+returnType;
    }
}
