package lclang.libs.reflection;

import lclang.Global;
import lclang.libs.Library;
import lclang.libs.lang.classes.ArrayClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.types.Types;

import java.util.ArrayList;

public class ReflectionLibrary extends Library {
    public ReflectionLibrary() {
        super("refLib");
        classes.put("ReflectionValue", ReflectionValue.INSTANCE);
        globals.put("reflection", new ReflectionClass());
    }

    public static class ReflectionClass extends LibraryClass {
        public ReflectionClass() {
            super("Reflection");
            globals.put("getLink", ReflectionValue.INSTANCE.constructor);
            globals.put("getLibraries", method((caller, lcClasses) ->
                    new ArrayClass(new ArrayList<>(Global.javaLibraries)), Types.ANY, ArrayClass.type));
        }
    }
}
