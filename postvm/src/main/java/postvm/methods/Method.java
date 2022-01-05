package postvm.methods;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.List;

public class Method extends PostVMClass {
    public static final String name = "callable";
    public static final Method INSTANCE = new Method();
    public static final Type type = INSTANCE.classType;

    public List<Type> args;
    public Type returnType;

    private Method() {
        super(name);
    }

    public Method(List<Type> args, Type returnType) {
        super(name);
        this.args = args;
        this.returnType = returnType;
        this.classType = new CallableType(args, returnType);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "call": return method((caller, args) -> call(caller, args.get(0)
                    .cast(ArrayClass.class).value), ArrayClass.type, PostVMClass.OBJECT_TYPE);
        }

        return super.loadGlobal(target);
    }

    public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
        return NullClass.INSTANCE;
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return classType.toString();
    }
}
