package postvm.methods;

import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.types.CallableType;
import postvm.types.Type;

public class MethodInstance extends LibraryClassInstance {
    public static final int NO_INSTANCE = -1;
    public static final PostVMClassPrototype<MethodInstance> PROTOTYPE = new PostVMClassPrototype<>(
            "callable",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf()
    ) {

        @Override
        public int createClass(int caller, int[] args) {
            return new MethodInstance(new Type[0], VoidClassInstance.PROTOTYPE.type).classId;
        }

        @Override
        public MethodInstance loadMethod(String target) {
            switch (target) {
                case "call":
                    return nativeMethod(
                            ObjectClassInstance.OBJECT_TYPE,
                            (inst, caller, args) ->
                                    ((MethodInstance) PostVMClassInstance.getInstance(inst)).call(
                                            args[0],
                                            caller,
                                            PostVMClassInstance.instances.get(args[1])
                                                    .cast(ArrayClassInstance.class).value.stream().mapToInt(i -> i).toArray()
                                    )
                            , ArrayClassInstance.type);
            }

            return super.loadMethod(target);
        }
    };

    public static final Type type = PROTOTYPE.type;

    public Type[] args;
    public Type returnType;

    public MethodInstance(Type[] args, Type returnType) {
        super(0, PROTOTYPE);
        this.args = args;
        this.returnType = returnType;
    }

    public int call(int thisClazz, int caller, int[] args) throws LCLangRuntimeException {
        return VoidClassInstance.INSTANCE.classId;
    }

    @Override
    public String toString(int caller) throws LCLangRuntimeException {
        return new CallableType(args, returnType).toString();
    }
}
