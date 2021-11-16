package lclang;

import lclang.methods.Method;
import lclang.types.NamedType;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public String toString() {
        try {
            Caller caller = new Caller(this, 0, 0, null);

            Value toStringMethod = globals.get("toString");
            if(toStringMethod!=null) {
                LCClass clazz = toStringMethod.get.invoke(caller);
                if(clazz instanceof Method) {
                    Method method = (Method) clazz;
                    return String.valueOf(method.call(caller, Collections.emptyList()));
                }
            }

            StringBuilder parameters = new StringBuilder();
            Set<Map.Entry<String, Value>> entries = executor.variables.entrySet();
            for (Map.Entry<String, Value> entry : entries) {
                parameters
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue().type)
                        .append(" = ")
                        .append(entry.getValue().get.invoke(caller))
                        .append(",");
            }

            return "$name@class"+classId+": {" + parameters + "}";
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return classId;
    }
}
