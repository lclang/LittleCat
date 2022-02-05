package postvm.methods;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.List;

public class Method extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "callable",
            PostVMClass.PROTOTYPE,
            Utils.listOf()
    ){

        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return new Method(Utils.listOf(), VoidClass.PROTOTYPE.type);
        }
    };

    public static final Type type = PROTOTYPE.type;

    public List<Type> args;
    public Type returnType;


    public Method(List<Type> args, Type returnType) {
        super(null, PROTOTYPE);
        this.args = args;
        this.returnType = returnType;
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
        return VoidClass.INSTANCE;
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return new CallableType(args, returnType).toString();
    }
}
