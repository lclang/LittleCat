package postvm.library.classes;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.Method;
import postvm.types.Type;

import java.util.List;

public abstract class PostVMClassPrototype {
    public final String name;
    public final PostVMClassPrototype extendsClass;
    public final Type type = new Type(this);
    private final List<Type> args;

    public PostVMClassPrototype(String name,
                                PostVMClassPrototype extendsClass,
                                List<Type> args) {
        this.name = name;
        this.args = args;
        this.extendsClass = extendsClass;
    }

    public Method getConstructor() {
        return new Method(args, type) {
            @Override
            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
                return createClass(caller, args);
            }
        };
    }

    public abstract PostVMClass createClass(Caller caller, List<PostVMClass> args);

    public boolean canCast(PostVMClassPrototype prototype) {
        return name.equals(prototype.name) ||
                extendsClass != null &&
                extendsClass.canCast(prototype);
    }
}
