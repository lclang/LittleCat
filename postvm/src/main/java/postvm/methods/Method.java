package postvm.methods;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.types.CallableType;
import postvm.types.Type;

public class Method extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "callable",
            ObjectClass.PROTOTYPE,
            Utils.listOf()
    ){

        @Override
        public int createClass(Caller caller, int[] args) {
            return new Method(new Type[0], VoidClass.PROTOTYPE.type).classId;
        }
    };

    public static final Type type = PROTOTYPE.type;

    public Type[] args;
    public Type returnType;

    public Method(Type[] args, Type returnType) {
        super(null, PROTOTYPE);
        this.args = args;
        this.returnType = returnType;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "call": return nativeMethod(
                    ObjectClass.OBJECT_TYPE,
                    (caller, args) ->
                            call(
                                    caller,
                                    PostVMClass.instances.get(args[0])
                                        .cast(ArrayClass.class).value.stream().mapToInt(i->i).toArray()
                            )
                    , ArrayClass.type);
        }

        return super.loadGlobal(clazz, target);
    }

    public int call(Caller caller, int[] args) throws LCLangRuntimeException {
        return VoidClass.INSTANCE.classId;
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return new CallableType(args, returnType).toString();
    }
}
