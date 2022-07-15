package postvm.library.classes;

import postvm.*;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.Type;
import postvm.utils.Function;
import postvm.utils.Function2;
import postvm.utils.VoidMethod2;

import java.util.*;

public abstract class PostVMClass {
    public static final class Constants {
        public final static String FIELD_ID = "__id";
        public final static String FIELD_TYPE = "__type";
        public final static String FIELD_EXTENDS = "__extends";
        public final static String FIELD_PROTOTYPE = "__prototype";
    }

    public final static List<PostVMClass> instances = new ArrayList<>();


    public final int classId = instances.size();
    public final PostVMClassPrototype prototype;

    public final String path;
    public final PostVMClass extendsClass;

    public final HashMap<String, PostVMClassPrototype> classes = new HashMap<>();
    public final PostVMExecutor executor = new PostVMExecutor(this);
    public List<PostVMClass> parents = new ArrayList<>();

    private Link link;

    {
        instances.add(this);
    }

    public PostVMClass(
            Caller caller,
            PostVMClassPrototype prototype,
            Integer[] extendsArgs) {
        this(caller, prototype, prototype.name, extendsArgs);
    }

    public PostVMClass(
            Caller caller,
            PostVMClassPrototype prototype,
            String path,
            Integer[] extendsArgs) {

        this.prototype = prototype;
        this.path = path;
        PostVMClass extendsClass = createExtendsClass();
        if(extendsClass==null) {
            PostVMClassPrototype extendsPrototype = prototype.getExtendsClass();
            if(extendsPrototype!=null)
                extendsClass = PostVMClass.instances.get(extendsPrototype.createClass(caller, extendsArgs));
        }

        this.extendsClass = extendsClass;
    }

    public PostVMClass createExtendsClass() {
        return null;
    }

    public Integer loadGlobal(PostVMClass clazz, String target) {
        if(extendsClass != null) {
            Integer global = extendsClass.getGlobal(clazz, target);
            if(global!=null) return global;
        }

        switch (target) {
            case "equals": return method(BoolClass.type, (caller, args) -> BoolClass.get(args[0].classId == classId),
                    ObjectClass.OBJECT_TYPE);
            case "toString": return method(StringClass.type, (caller, args) -> {
                List<String> parameters = new ArrayList<>();
                Set<Map.Entry<String, Integer>> entries = executor.variables.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    PostVMClass variable = PostVMClass.instances.get(entry.getValue());
                    parameters.add(entry.getKey()+": "+variable.prototype.name+" = "+
                            variable.toString(caller));
                }

                return StringClass.get(clazz.prototype.name+"@class"+classId+": { " + String.join(", ", parameters) + " }");
            });

            case Constants.FIELD_ID: return NumberClass.get(classId);
            case Constants.FIELD_EXTENDS: return extendsClass==null ? NullClass.INSTANCE.classId : extendsClass.classId;
            case Constants.FIELD_TYPE: return StringClass.get(clazz.prototype.name);
            case Constants.FIELD_PROTOTYPE: return clazz.prototype.getConstructor().classId;

            case "this": return clazz.classId;
        }

        return null;
    }

    public PostVMClassPrototype getClass(String name) {
        PostVMClassPrototype clazz = classes.get(name);
        if(clazz==null) for (PostVMClass parent: parents){
            clazz = parent.getClass(name);
            if(clazz!=null) return clazz;
        }

        return clazz;
    }

    public Integer getGlobal(String name) {
        return getGlobal(this, name);
    }

    public Integer getGlobal(PostVMClass clazz, String name) {
        Integer clazzId = CacheManager.cashedClasses.get(clazz.prototype.name+classId+name);
        if(clazzId!=null) {
            return clazzId;
        }

        Integer global = null;
        for(PostVMClass parent: parents){
            global = parent.getGlobal(clazz, name);
            if(global!=null) break;
        }

        if(global==null) {
            Integer classId = loadGlobal(clazz, name);
            if(classId!=null) global = classId;
        }

        if(global!=null) {
            CacheManager.saveCache(clazz.prototype.name+classId+name, global);
        }

        return global;
    }

    public Link createLink() {
        if(link==null) {
            link = new Link(classId, Link.State.NOTHING);
        }

        return link;
    }

    public int equals(PostVMClass another, Caller caller) {
        Integer result = getGlobal("equals");
        if(result!=null) {
            PostVMClass clazz = PostVMClass.instances.get(result);
            if(clazz instanceof Method) {
                return ((Method) clazz).call(caller, new Integer[]{another.classId});
            }

            return result;
        }

        return BoolClass.TRUE;
    }

    @Override
    @Deprecated
    public boolean equals(Object o) {
        throw new RuntimeException("USE EQUALS WITH CALLER!!!");
    }

    public String toString(Caller caller) throws LCLangRuntimeException {
        Integer result = getGlobal("toString");
        if(result!=null) {
            PostVMClass clazz = PostVMClass.instances.get(result);
            if(clazz instanceof Method) {
                int response = ((Method) clazz).call(caller, new Integer[0]);
                return ((StringClass) PostVMClass.instances.get(response)).string;
            }

            if(clazz instanceof StringClass){
                return ((StringClass) clazz).string;
            }
        }

        throw new LCLangTypeErrorException("Expected string return type in method toString()", caller);
    }

    @Override
    @Deprecated
    public final String toString() {
        throw new RuntimeException();
    }

    @SuppressWarnings("unchecked")
    public <T> T cast(Class<T> clazz) {
        if(clazz.equals(getClass()))
            return (T) this;
        else if(extendsClass!=null)
            return extendsClass.cast(clazz);
        else {
            new Throwable().printStackTrace();

            throw new LCLangTypeErrorException("PostVM Error: Invalid cast: "+prototype.name+" as "+clazz.getName()+".\n" +
                    "Please report error to GitHub: https://github.com/lclang/LittleCat",
                    new Caller(this, -1));
        }
    }

    public static int voidMethod(VoidMethod2<Caller, PostVMClass[]> body, Type... arguments) {
        return new Method(arguments, VoidClass.PROTOTYPE.type) {
            @Override
            public int call(Caller caller, Integer[] args_) throws LCLangRuntimeException {
                PostVMClass[] args = new PostVMClass[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = PostVMClass.instances.get(args_[i]);
                    else args[i] = VoidClass.INSTANCE;
                }


                body.invoke(
                        caller,
                        args
                );

                return VoidClass.INSTANCE.classId;
            }
        }.classId;
    }

    public static int voidNativeMethod(VoidMethod2<Caller, Integer[]> body, Type... arguments) {
        return new Method(arguments, VoidClass.PROTOTYPE.type) {
            @Override
            public int call(Caller caller, Integer[] args_) throws LCLangRuntimeException {
                Integer[] args = new Integer[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = args_[i];
                    else args[i] = VoidClass.INSTANCE.classId;
                }


                body.invoke(
                        caller,
                        args
                );

                return VoidClass.INSTANCE.classId;
            }
        }.classId;
    }

    public static int nativeMethod(Type returnType, Function2<Caller, Integer[], Integer> body, Type... arguments) {
        return new Method(arguments, returnType) {
            @Override
            public int call(Caller caller, Integer[] args_) throws LCLangRuntimeException {
                Integer[] args = new Integer[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = args_[i];
                    else args[i] = VoidClass.INSTANCE.classId;
                }

                return body.invoke(
                        caller,
                        args
                );
            }
        }.classId;
    }


    public static int method(Type returnType, Function2<Caller, PostVMClass[], Integer> body, Type... arguments) {
        return new Method(arguments, returnType) {
            @Override
            public int call(Caller caller, Integer[] args_) throws LCLangRuntimeException {
                PostVMClass[] args = new PostVMClass[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = PostVMClass.instances.get(args_[i]);
                    else args[i] = VoidClass.INSTANCE;
                }

                return body.invoke(
                        caller,
                        args
                );
            }
        }.classId;
    }


    public static int methodOld(Type returnType, Function2<Caller, PostVMClass[], PostVMClass> body, Type... arguments) {
        return new Method(arguments, returnType) {
            @Override
            public int call(Caller caller, Integer[] args_) throws LCLangRuntimeException {
                PostVMClass[] args = new PostVMClass[arguments.length];
                for (int i = 0, l = args.length; i < l; i++) {
                    if(i < args_.length) args[i] = PostVMClass.instances.get(args_[i]);
                    else args[i] = VoidClass.INSTANCE;
                }

                return body.invoke(
                        caller,
                        args
                ).classId;
            }
        }.classId;
    }

    public static int toStrMethod(Function<Caller, Integer> body) {
        return method(StringClass.type, (caller, lcClasses) -> body.invoke(caller));
    }
}
