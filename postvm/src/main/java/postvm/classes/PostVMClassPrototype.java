package postvm.classes;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.methods.MethodInstance;
import postvm.types.Type;
import postvm.utils.*;

import java.util.*;

public abstract class PostVMClassPrototype<
        Instance extends PostVMClassInstance
> {
    public final String name;
    public final Type type = new Type(this);
    public final Type[] args;
    public final boolean finalClazz;

    private final PostVMClassPrototype<? extends PostVMClassInstance> extendsClass;
    private Integer constructor = null;

    public PostVMClassPrototype(String name,
                                PostVMClassPrototype<? extends PostVMClassInstance> extendsClass,
                                Type[] args,
                                boolean finalClazz) {
        this.name = name;
        this.args = args;
        this.extendsClass = extendsClass;
        this.finalClazz = finalClazz;
    }


    public PostVMClassPrototype(String name,
                                PostVMClassPrototype<? extends PostVMClassInstance> extendsClass,
                                Type[] args) {
        this(name, extendsClass, args, false);
    }

    public PostVMClassPrototype(String name,
                                PostVMClassPrototype<? extends PostVMClassInstance> extendsClass,
                                List<Type> args) {
        this(name, extendsClass, args.toArray(new Type[0]), false);
    }

    public PostVMClassPrototype<? extends PostVMClassInstance> getExtendsClass() {
        return extendsClass;
    }

    public Integer getConstructor() {
        if(constructor==null) constructor = new MethodInstance(args, type) {
            @Override
            public int call(int thisClazz, int caller, int[] args) throws LCLangRuntimeException {
                return createClass(caller, args);
            }
        }.classId;

        return constructor;
    }

    public abstract int createClass(int caller, int[] args);

    public MethodInstance loadMethod(String target) {
        if(getExtendsClass() != null) {
            MethodInstance method = getExtendsClass().loadMethod(target);
            if(method!=null) return method;
        }

        switch (target) {
            case "equals": return nativeMethod(
                    BoolClassInstance.type,
                    (inst, caller, args) -> BoolClassInstance.get(Objects.equals(args[0], inst)),
                    ObjectClassInstance.OBJECT_TYPE
            );
            case "toString": return method(
                    StringClassInstance.type,
                    (inst, caller, args) -> StringClassInstance.get(toString(inst, caller))
            );
        }

        return null;
    }

    public String toString(Instance inst, int caller) {
        List<String> parameters = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = inst.executor.variables.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            PostVMClassInstance variable = PostVMClassInstance.instances.get(entry.getValue());
            parameters.add(entry.getKey()+": "+variable.prototype.name+" = "+
                    variable.toString(caller));
        }

        return inst.prototype.name+"@class"+inst.classId+": { " + String.join(", ", parameters) + " }";
    }

    public MethodInstance voidMethod(
            VoidMethod3<Instance, Integer, PostVMClassInstance[]> body,
            Type... arguments
    ) {
        return new MethodInstance(arguments, VoidClassInstance.PROTOTYPE.type) {
            @Override
            public int call(int thisClazz, int caller, int[] args_) throws LCLangRuntimeException {
                PostVMClassInstance[] args = new PostVMClassInstance[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = PostVMClassInstance.instances.get(args_[i]);
                    else args[i] = VoidClassInstance.INSTANCE;
                }


                body.invoke(
                        (Instance) PostVMClassInstance.getInstance(thisClazz),
                        caller,
                        args
                );

                return VoidClassInstance.INSTANCE.classId;
            }
        };
    }

    public MethodInstance voidNativeMethod(
            VoidMethod3<Instance, Integer, Integer[]> body,
            Type... arguments
    ) {
        return new MethodInstance(arguments, VoidClassInstance.PROTOTYPE.type) {
            @Override
            public int call(int thisClazz, int caller, int[] args_) throws LCLangRuntimeException {
                Integer[] args = new Integer[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = args_[i];
                    else args[i] = VoidClassInstance.INSTANCE.classId;
                }


                body.invoke(
                        (Instance) PostVMClassInstance.getInstance(thisClazz),
                        caller,
                        args
                );

                return VoidClassInstance.INSTANCE.classId;
            }
        };
    }

    public MethodInstance nativeArgsMethod(
            Type returnType,
            Function3<Instance, Integer, Integer[], Integer> body,
            Type... arguments
    ) {
        return new MethodInstance(arguments, returnType) {
            @Override
            public int call(int thisClazz, int caller, int[] args_) throws LCLangRuntimeException {
                Integer[] args = new Integer[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = args_[i];
                    else args[i] = VoidClassInstance.INSTANCE.classId;
                }

                return body.invoke(
                        (Instance) PostVMClassInstance.getInstance(thisClazz),
                        caller,
                        args
                );
            }
        };
    }

    public MethodInstance nativeMethod(
            Type returnType,
            Function3<Integer, Integer, Integer[], Integer> body,
            Type... arguments
    ) {
        return new MethodInstance(arguments, returnType) {
            @Override
            public int call(int thisClazz, int caller, int[] args_) throws LCLangRuntimeException {
                Integer[] args = new Integer[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = args_[i];
                    else args[i] = VoidClassInstance.INSTANCE.classId;
                }

                return body.invoke(
                        thisClazz,
                        caller,
                        args
                );
            }
        };
    }


    public MethodInstance method(
            Type returnType,
            Function3<Instance, Integer, PostVMClassInstance[], Integer> body,
            Type... arguments
    ) {
        return new MethodInstance(arguments, returnType) {
            @Override
            public int call(int thisClazz, int caller, int[] args_) throws LCLangRuntimeException {
                PostVMClassInstance[] args = new PostVMClassInstance[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = PostVMClassInstance.getInstance(args_[i]);
                    else args[i] = VoidClassInstance.INSTANCE;
                }

                return body.invoke(
                        (Instance) PostVMClassInstance.getInstance(thisClazz),
                        caller,
                        args
                );
            }
        };
    }

    public boolean canCast(PostVMClassPrototype prototype) {
        return name.equals(prototype.name) ||
                getExtendsClass() != null &&
                getExtendsClass().canCast(prototype);
    }
}
