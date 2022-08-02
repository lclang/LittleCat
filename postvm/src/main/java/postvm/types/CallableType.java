package postvm.types;

import postvm.TypeUtils;
import postvm.Utils;
import postvm.methods.Method;

import java.util.Arrays;

public class CallableType extends Type {
    public final Type[] args;
    public final Type returnType;

    public CallableType(Type[] args, Type returnType) {
        super(Method.PROTOTYPE);
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
        Type returnType = args[0];
        Type[] arguments = new Type[args.length-1];
        System.arraycopy(args, 1, arguments, 0, arguments.length);

        return new CallableType(arguments, returnType);
    }

    @Override
    public String toString() {
        return "("+ Utils.joinToString(", ", Arrays.asList(args), Type::toString)+") -> "+returnType;
    }
}
