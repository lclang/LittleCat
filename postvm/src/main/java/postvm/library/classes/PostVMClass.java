package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMRoot;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.Method;
import postvm.types.Type;

import java.util.*;

public class PostVMClass extends PostVMRoot {
    public static int classesCount = 0;
    public static PostVMClass OBJECT_INSTANCE = new PostVMClass();
    public static Type OBJECT_TYPE = PostVMClass.OBJECT_INSTANCE.classType;

    public final String name;
    public final int classId = classesCount++;
    public Type classType = new Type(this);
    public PostVMClass extendsClass;
    public Method constructor = null;

    private PostVMClass() {
        super("any");
        this.name = "any";
    }

    public PostVMClass(String name) {
        this(name, name);
    }
    public PostVMClass(String name, String path) {
        super(path);
        this.name = name;
        this.extendsClass = new PostVMClass();
    }

    @Override
    public PostVMClass getVariableClass(Caller caller, String name) throws LCLangRuntimeException {
        PostVMClass value = super.getVariableClass(caller, name);
        if(value==null&&extendsClass!=null)
            return extendsClass.getVariableClass(caller, name);

        return value;
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

    public boolean equals(PostVMClass other) {
        return classId == other.classId;
    }

    public String toString(Caller caller) throws LCLangRuntimeException {
        PostVMClass clazz = globals.get("toString");
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
        return (T) this;
    }
}
