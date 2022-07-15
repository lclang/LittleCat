package postvm.library.classes;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.Method;
import postvm.types.Type;

import java.util.List;

public abstract class PostVMClassPrototype {
    public final String name;
    public final Type type = new Type(this);
    public final Type[] args;
    public final boolean finalClazz;

    private final PostVMClassPrototype extendsClass;
    private Integer constructor = null;

    public PostVMClassPrototype(String name,
                                PostVMClassPrototype extendsClass,
                                Type[] args,
                                boolean finalClazz) {
        this.name = name;
        this.args = args;
        this.extendsClass = extendsClass;
        this.finalClazz = finalClazz;
    }


    public PostVMClassPrototype(String name,
                                PostVMClassPrototype extendsClass,
                                Type[] args) {
        this(name, extendsClass, args, false);
    }

    public PostVMClassPrototype(String name,
                                PostVMClassPrototype extendsClass,
                                List<Type> args) {
        this(name, extendsClass, args.toArray(new Type[0]), false);
    }

    public PostVMClassPrototype getExtendsClass() {
        return extendsClass;
    }

    public Integer getConstructor() {
        if(constructor==null) constructor = new Method(args, type) {
            @Override
            public int call(Caller caller, int[] args) throws LCLangRuntimeException {
                return createClass(caller, args);
            }
        }.classId;

        return constructor;
    }

    public abstract int createClass(Caller caller, int[] args);

    public boolean canCast(PostVMClassPrototype prototype) {
        return name.equals(prototype.name) ||
                getExtendsClass() != null &&
                getExtendsClass().canCast(prototype);
    }
}
