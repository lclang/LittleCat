package postvm.library.classes;

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
    public static int classesCount = 0;
    public static PostVMClass OBJECT_INSTANCE = new PostVMClass();
    public static Type OBJECT_TYPE = PostVMClass.OBJECT_INSTANCE.classType;

    public final String name;
    public final String path;
    public final int classId = classesCount++;
    public final HashMap<String, PostVMClass> classes = new HashMap<>();
    public final PostVMExecutor executor = new PostVMExecutor(this);
    public Type classType = new Type(this);
    public PostVMClass extendsClass = null;
    public List<PostVMClass> parents = new ArrayList<>();
    public Method constructor = null;

    private final HashMap<String, PostVMClass> globals = new HashMap<>();

    private PostVMClass() {
        this.name = "any";
        this.path = "undefined";
    }

    public PostVMClass(String name) {
        this(name, name);
    }

    public PostVMClass(String name, String path) {
        this.name = name;
        this.path = path;
        this.extendsClass = new PostVMClass();
    }

    public PostVMClass loadGlobal(String target) {
        if(extendsClass!=null) {
            PostVMClass global = extendsClass.loadGlobal(target);
            if(global!=null) return global;
        }

        for(PostVMClass parent: parents) {
            PostVMClass global = parent.loadGlobal(target);
            if(global!=null) return global;
        }

        switch (target) {
            case "equals": return method((caller, args) -> BoolClass.get(args.get(0).classId == classId),
                    PostVMClass.OBJECT_TYPE, BoolClass.type);
            case "this": return this;
        }

        return null;
    }

    public PostVMClass getClass(String name) {
        PostVMClass clazz = classes.get(name);
        if(clazz==null) for (PostVMClass parent: parents){
            clazz = parent.getClass(name);
            if(clazz!=null) return clazz;
        }

        return clazz;
    }

    public PostVMClass getGlobal(String name) {
        PostVMClass global = globals.getOrDefault(name, null);
        if(global==null) {
            global = loadGlobal(name);
            globals.put(name, global);
        }

        return global;
    }

    public Link getVariableClass(Caller caller, String name) throws LCLangRuntimeException {
        PostVMClass value = getGlobal(name);
        if(value==null) {
            if(extendsClass!=null)
                return extendsClass.getVariableClass(caller, name);

            return VoidClass.value;
        }

        return value.createLink();
    }

    public boolean canCast(PostVMClass another) {
        return Objects.equals(another.name, name) ||
                    extendsClass!=null &&
                    extendsClass.canCast(another);
    }

    public Link createLink() {
        return new Link(Link.State.NOTHING) {
            @Override
            public PostVMClass get(Caller caller) throws LCLangRuntimeException {
                return PostVMClass.this;
            }
        };
    }

    public PostVMClass equals(PostVMClass another, Caller caller) {
        return getGlobal("equals").cast(Method.class).call(caller, Collections.singletonList(another));
    }

    @Override
    @Deprecated
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, classId, classes, executor, classType, extendsClass, parents, constructor, globals);
    }

    public String toString(Caller caller) throws LCLangRuntimeException {
        PostVMClass clazz = getGlobal("toString");
        if(clazz instanceof Method) {
            Method method = (Method) clazz;
            return ((StringClass) method.call(caller, Collections.emptyList())).string;
        }

        List<String> parameters = new ArrayList<>();
        Set<Map.Entry<String, PostVMClass>> entries = executor.variables.entrySet();
        for (Map.Entry<String, PostVMClass> entry : entries) {
            parameters.add(entry.getKey()+": "+entry.getValue().name+" = "+
                    entry.getValue().toString(caller));
        }

        return name+"@class"+classId+": { " + String.join(", ", parameters) + " }";
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
        else throw new LCLangTypeErrorException("PostVM Error: Invalid cast: "+name+" as "+clazz.getName()+".\n" +
                    "Please report error to GitHub: https://github.com/lclang/LittleCat",
                    new Caller(this, -1));
    }

    public Method voidMethod(VoidMethod2<Caller, List<PostVMClass>> body, Type... args) {
        List<Type> arguments = Arrays.asList(args);

        return new Method(arguments, VoidClass.type) {
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

    public Method method(Function2<Caller, List<PostVMClass>, PostVMClass> body, Type... args) {
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
