package lclang;

import lclang.libs.Library;
import lclang.libs.lang.LangLibrary;
import lclang.libs.lang.classes.LCClass;
import lclang.libs.reflection.ReflectionLibrary;
import lclang.libs.std.StdLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Global {
    public static final String version;
    public static final int buildTime;
    public static final ArrayList<LCRootExecutor> libraries = new ArrayList<>();
    public static final ArrayList<Library> javaLibraries = new ArrayList<>();
    public static final Map<Object, LCClass> cashedClasses = new HashMap<>();

    public static void saveCache(Object value, LCClass clazz) {
        cashedClasses.put(value, clazz);
    }

    static {
        ResourceBundle prop = ResourceBundle.getBundle("build");
        version = prop.getString("version");
        buildTime = Integer.parseInt(prop.getString("buildTime"));

        javaLibraries.add(new LangLibrary());
        javaLibraries.add(new StdLibrary());
        javaLibraries.add(new ReflectionLibrary());
    }
}
