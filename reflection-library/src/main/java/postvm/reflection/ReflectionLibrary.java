package postvm.reflection;

import postvm.Library;

public class ReflectionLibrary extends Library {
    public ReflectionLibrary() {
        super("refLib");
        classes.put("ReflectionLink", ReflectionLink.INSTANCE);
//        globals.put("reflection", new ReflectionClass());
    }

//    public static class ReflectionClass extends LibraryClass {
//        public ReflectionClass() {
//            super("Reflection");
//            globals.put("getLink", ReflectionLink.INSTANCE.constructor);
//            globals.put("getLibraries", method((caller, lcClasses) ->
//                    new ArrayClass(new ArrayList<>(Global.javaLibraries)), ArrayClass.type));
//        }
//    }
}
