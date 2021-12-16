package postvm;

import postvm.library.classes.PostVMClass;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    public static final Map<Object, PostVMClass> cashedClasses = new HashMap<>();
    public static void saveCache(Object value, PostVMClass clazz) {
        cashedClasses.put(value, clazz);
    }
}
