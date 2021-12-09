package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.LCRootExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.methods.Method;
import lclang.types.NamedType;
import lclang.types.Type;

import java.util.*;

public class LCClass extends LCRootExecutor {
    public static int classesCount = 0;
    public static LCClass INSTANCE = new LCClass();

    public final String name;
    public final int classId = classesCount++;
    public Type classType = new NamedType(this);
    public LCClass extendsClass;
    public Method constructor = null;

    private LCClass() {
        super("any");
        this.name = "any";
    }

    public LCClass(String name) {
        this(name, name);
    }
    public LCClass(String name, String path) {
        super(path);
        this.name = name;
        this.extendsClass = new LCClass();
    }

    @Override
    public Link getLink(Caller caller, String name) throws LCLangRuntimeException {
        Link value = super.getLink(caller, name);
        if(value==null&&extendsClass!=null)
            return extendsClass.executor.getLink(caller, name);

        return value;
    }

    public Link createLink(){
        return new Link(this, Link.State.NOTHING);
    }

    public boolean canCast(LCClass another) {
        return Objects.equals(another.name, name) ||
                    extendsClass!=null &&
                    extendsClass.canCast(another);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof LCClass && classId == ((LCClass) other).classId;
    }

    public String toString(Caller caller) throws LCLangRuntimeException {
        LCClass clazz = globals.get("toString");
        if(clazz instanceof Method) {
            Method method = (Method) clazz;
            return ((StringClass) method.call(caller, Collections.emptyList())).string;
        }

        List<String> parameters = new ArrayList<>();
        Set<Map.Entry<String, LCClass>> entries = executor.variables.entrySet();
        for (Map.Entry<String, LCClass> entry : entries) {
            parameters.add(entry.getKey()+": "+entry.getValue().name+" = "+
                    entry.getValue().toString(caller));
        }

        return name+"@class"+classId+": { " + String.join(", ", parameters) + " }";
    }

    @Override
    @Deprecated
    public String toString() {
        try {
            return toString(new Caller(this, 0, null));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T cast(Class<T> clazz) {
        return (T) this;
    }
}
