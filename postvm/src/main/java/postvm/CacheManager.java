package postvm;

import postvm.library.classes.PostVMClass;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheManager {
    public static final WeakHashMap<Object, PostVMClass> cashedClasses = new WeakHashMap<>();
    private static final ScheduledExecutorService cacheClearTaskScheduler = Executors.newSingleThreadScheduledExecutor();
    private static final Runnable cacheClearTask = new Runnable() {
        public int classesCount = cashedClasses.size();

        @Override
        public void run() {
            if(cashedClasses.size()-classesCount>15){
                System.out.println("[CM] Starting clear cache");
                classesCount = 0;
                cashedClasses.clear();
                System.gc();
            }else classesCount = cashedClasses.size();
        }
    };

    public static void saveCache(Object value, PostVMClass clazz) {
        cashedClasses.put(value, clazz);
    }

    public static void clearCache() {
        cacheClearTaskScheduler.execute(cacheClearTask);
    }

    static {
//        cacheClearTaskScheduler.scheduleAtFixedRate(cacheClearTask, 0,1, TimeUnit.NANOSECONDS);
    }
}
