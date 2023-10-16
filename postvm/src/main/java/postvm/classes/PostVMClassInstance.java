package postvm.classes;

import postvm.*;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
import postvm.methods.MethodInstance;

import java.util.*;

public abstract class PostVMClassInstance {
    public static final class Constants {
        public final static String FIELD_ID = "__id";
        public final static String FIELD_TYPE = "__type";
    }

    public static ArrayDeque<Integer> reuseIds = new ArrayDeque<>();
    public final static List<PostVMClassInstance> instances = new ArrayList<>();

    public static int lastInstanceId = 0;
    public final int classId = instances.size();
    public final int instance = reuseIds.peek() != null ? reuseIds.pop(): lastInstanceId++;

    public final PostVMClassPrototype<? extends PostVMClassInstance> prototype;

    public final String path;

    public final HashMap<String, PostVMClassPrototype<PostVMClassInstance>> classes = new HashMap<>();
    public final PostVMExecutor executor = new PostVMExecutor(this);
    public List<PostVMClassInstance> parents = new ArrayList<>();
    private PostVMClassInstance extendsClass;
    private Link link;

    public static PostVMClassInstance getInstance(int classId) {
        return instances.get(classId);
    }

    public static void destroy(int classId) {
        instances.set(classId, null);
        reuseIds.add(classId);
    }

    {
        instances.add(this);
    }

    public PostVMClassInstance(
            int caller,
            PostVMClassPrototype<? extends PostVMClassInstance> prototype,
            int[] extendsArgs) {
        this(caller, prototype, prototype.name, extendsArgs);
    }

    public PostVMClassInstance(
            int caller,
            PostVMClassPrototype<? extends PostVMClassInstance> prototype,
            String path,
            int[] extendsArgs) {
        this.prototype = prototype;
        this.path = path;
        this.extendsClass = createExtendsClass();
        if (extendsClass == null) {
            PostVMClassPrototype<? extends PostVMClassInstance> extendsPrototype = prototype.getExtendsClass();
            if (extendsPrototype != null)
                extendsClass = PostVMClassInstance.instances.get(extendsPrototype.createClass(caller, extendsArgs));
        }

        this.executor.variables.put(Constants.FIELD_ID, NumberClassInstance.get(classId));
        this.executor.variables.put(Constants.FIELD_TYPE, StringClassInstance.get(prototype.name));
    }

    public PostVMClassInstance createExtendsClass() {
        return null;
    }

    public PostVMClassInstance getExtendsClass() {
        return extendsClass;
    }

    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        MethodInstance methodInstance = prototype.loadMethod(target);

        return new MethodInstance() {

        };
    }

    public PostVMClassPrototype<PostVMClassInstance> getClass(String name) {
        PostVMClassPrototype<PostVMClassInstance> clazz = classes.get(name);
        if(clazz==null) for (PostVMClassInstance parent: parents){
            clazz = parent.getClass(name);
            if(clazz!=null) return clazz;
        }

        return clazz;
    }
    public Integer getGlobal(PostVMClassInstance clazz, String name) {
        Integer clazzId = CacheManager.cashedClasses.get(clazz.prototype.name+classId+name);
        if(clazzId!=null) {
            return clazzId;
        }

        Integer global = null;
        for(PostVMClassInstance parent: parents){
            global = parent.getGlobal(clazz, name);
            if(global!=null) break;
        }

        if(global==null) {
            Integer classId = loadMethod(clazz, name);
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

    public int equals(PostVMClassInstance another, int caller) {
        Integer result = getGlobal("equals");
        if(result!=null) {
            PostVMClassInstance clazz = PostVMClassInstance.instances.get(result);
            if(clazz instanceof MethodInstance) {
                return ((MethodInstance) clazz).call(caller, classId, new int[]{another.classId});
            }

            return result;
        }

        return BoolClassInstance.TRUE;
    }

    @Override
    @Deprecated
    public boolean equals(Object o) {
        throw new RuntimeException("USE EQUALS WITH CALLER OR WITH CLASS ID!!!");
    }

    public String toString(int caller) throws LCLangRuntimeException {
        Integer result = getGlobal("toString");
        if(result!=null) {
            PostVMClassInstance clazz = PostVMClassInstance.instances.get(result);
            if(clazz instanceof MethodInstance) {
                int response = ((MethodInstance) clazz).call(caller, classId, new int[0]);
                return ((StringClassInstance) PostVMClassInstance.instances.get(response)).string;
            }

            if(clazz instanceof StringClassInstance){
                return ((StringClassInstance) clazz).string;
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
        else if(getExtendsClass()!=null)
            return getExtendsClass().cast(clazz);
        else {
            new Throwable().printStackTrace();

            throw new LCLangTypeErrorException("PostVM Error: Invalid cast: "+prototype.name+" as "+clazz.getName()+".\n" +
                    "Please report error to GitHub: https://github.com/lclang/LittleCat",
                    0);
        }
    }
}
