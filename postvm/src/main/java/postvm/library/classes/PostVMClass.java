package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.methods.Method;
import postvm.types.Type;
import postvm.utils.Function2;
import postvm.utils.VoidMethod2;

import java.util.*;

public class PostVMClass {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
        "any",
        null,
            Collections.emptyList()
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return new PostVMClass();
        }
    };

    public static int classesCount = 0;
    public static PostVMClass OBJECT_INSTANCE = new PostVMClass();
    public static Type OBJECT_TYPE = PROTOTYPE.type;

    public final int classId = classesCount++;
    public final PostVMClassPrototype prototype;

    public final String path;
    public final PostVMClass extendsClass;

    public final HashMap<String, PostVMClassPrototype> classes = new HashMap<>();
    public final PostVMExecutor executor = new PostVMExecutor(this);
    public List<PostVMClass> parents = new ArrayList<>();

    private Link link;

    private PostVMClass() {
        this.prototype = PROTOTYPE;
        this.path = "undefined";
        this.extendsClass = null;
    }

    public PostVMClass(
            Caller caller,
            PostVMClassPrototype prototype,
            List<PostVMClass> extendsArgs) {
        this(caller, prototype, prototype.name, extendsArgs);
    }

    public PostVMClass(
            Caller caller,
            PostVMClassPrototype prototype,
            String path,
            List<PostVMClass> extendsArgs) {

        this.prototype = prototype;
        this.path = path;
        PostVMClass extendsClass = createExtendsClass();
        if(extendsClass==null) this.extendsClass = prototype.extendsClass.createClass(caller, extendsArgs);
        else this.extendsClass = extendsClass;
    }

    public PostVMClass createExtendsClass() {
        return null;
    }

    public PostVMClass loadGlobal(String target) {
        if(extendsClass != null) {
            PostVMClass global = extendsClass.getGlobal(target);
            if(global!=null) return global;
        }

        switch (target) {
            case "equals": return method((caller, args) -> BoolClass.get(args.get(0).classId == classId),
                    PostVMClass.OBJECT_TYPE, BoolClass.type);
            case "toString": return method((caller, args) -> {
                List<String> parameters = new ArrayList<>();
                Set<Map.Entry<String, PostVMClass>> entries = executor.variables.entrySet();
                for (Map.Entry<String, PostVMClass> entry : entries) {
                    parameters.add(entry.getKey()+": "+entry.getValue().prototype.name+" = "+
                            entry.getValue().toString(caller));
                }

                return StringClass.get(prototype.name+"@class"+classId+": { " + String.join(", ", parameters) + " }");
            }, StringClass.type);

            case "this": return this;
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

    public PostVMClass getGlobal(String name) {
        for(PostVMClass parent: parents){
            PostVMClass global = parent.getGlobal(name);
            if(global!=null) return global;
        }

        PostVMClass global = CacheManager.cashedClasses.get(this.prototype.name+classId+name);
        if(global!=null) return global;

        global = loadGlobal(name);
        if(global!=null) {
            CacheManager.saveCache(this.prototype.name+classId+name, global);
            return global;
        }

        return null;
    }

    public PostVMClass getVariableClass(Caller caller, String name) throws LCLangRuntimeException {
        PostVMClass value = getGlobal(name);
        if(value==null) {
            if(extendsClass!=null)
                return extendsClass.getVariableClass(caller, name);

            return VoidClass.INSTANCE;
        }

        return value;
    }

    public boolean canCast(PostVMClass another) {
        return prototype.canCast(another.prototype);
    }

    public Link createLink() {
        if(link==null) link = new Link(Link.State.NOTHING) {
            @Override
            public PostVMClass get(Caller caller) throws LCLangRuntimeException {
                return PostVMClass.this;
            }
        };

        return link;
    }

    public PostVMClass equals(PostVMClass another, Caller caller) {
        return getGlobal("equals").cast(Method.class).call(caller, Collections.singletonList(another));
    }

    @Override
    @Deprecated
    public boolean equals(Object o) {
        return false;
    }

    public String toString(Caller caller) throws LCLangRuntimeException {
        PostVMClass clazz = getGlobal("toString");
        if(clazz instanceof Method) {
            Method method = (Method) clazz;
            return ((StringClass) method.call(caller, Collections.emptyList())).string;
        }

        throw new LCLangTypeErrorException("Expected method for toString global", caller);
    }

    @Override
    @Deprecated
    public final String toString() {
        throw new RuntimeException();
    }

    @SuppressWarnings("unchecked")
    public <T> T cast(Class<T> clazz) {
        if(clazz.isAssignableFrom(getClass()))
            return (T) this;
        else if(extendsClass!=null)
            return extendsClass.cast(clazz);
        else throw new LCLangTypeErrorException("PostVM Error: Invalid cast: "+prototype.name+" as "+clazz.getName()+".\n" +
                    "Please report error to GitHub: https://github.com/lclang/LittleCat",
                    new Caller(this, -1));
    }

    public Method voidMethod(VoidMethod2<Caller, List<PostVMClass>> body, Type... args) {
        List<Type> arguments = Arrays.asList(args);

        return new Method(arguments, VoidClass.PROTOTYPE.type) {
            @Override
            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
                while(arguments.size()>args.size()) {
                    args.add(VoidClass.INSTANCE);
                }

                body.invoke(
                        caller,
                        args
                );

                return VoidClass.INSTANCE;
            }
        };
    }

    public static Method method(Function2<Caller, List<PostVMClass>, PostVMClass> body, Type... args) {
        Type returnType = args[args.length-1];
        List<Type> arguments = new ArrayList<>(Arrays.asList(args));
        arguments.remove(args.length-1);

        return new Method(arguments, returnType) {
            @Override
            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
                while(arguments.size()>args.size()) {
                    args.add(VoidClass.INSTANCE);
                }

                return body.invoke(
                        caller,
                        args
                );
            }
        };
    }
}
