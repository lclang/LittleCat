package lclang;

import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.StringClass;
import lclang.methods.Method;
import lclang.types.NamedType;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LCClass extends LCRootExecutor {
    public static int classesCount = 0;

    public final String name;
    public final int classId = classesCount++;
    public LCClass extendsClass;
    public Method constructor = null;

    public LCClass(String name) {
        this(name, name);
    }

    public LCClass(String name, String path) {
        super(path);
        this.name = name;
    }

    @Nullable
    @Override
    public Value getLink(Caller caller, String name) throws LCLangRuntimeException {
        Value value = super.getLink(caller, name);
        if(value==null&&extendsClass!=null)
            return extendsClass.executor.getLink(caller, name);

        return value;
    }

    public Value asValue(){
        return new Value(new NamedType(this), this, Value.State.NOTHING);
    }

    public boolean canCast(LCClass another) {
        return Objects.equals(another.name, name) ||
            extendsClass!=null && extendsClass.canCast(another);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof LCClass && classId == other.hashCode();
    }

    public String toString(Caller caller) throws LCLangRuntimeException {
        Value toStringMethod = globals.get("toString");
        if(toStringMethod!=null) {
            LCClass clazz = toStringMethod.get.invoke(caller);
            if(clazz instanceof Method) {
                Method method = (Method) clazz;
                return ((StringClass) method.call(caller, Collections.emptyList()).get.invoke(caller)).string;
            }
        }

        List<String> parameters = new ArrayList<>();
        Set<Map.Entry<String, Value>> entries = executor.variables.entrySet();
        for (Map.Entry<String, Value> entry : entries) {
            parameters.add(entry.getKey()+": "+entry.getValue().type+" = "+
                    entry.getValue().get.invoke(caller));
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

    @Override
    public int hashCode() {
        return classId;
    }
}
