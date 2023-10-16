package postvm;

import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CacheManager {
    public static final WeakHashMap<Object, Integer> cashedClasses = new WeakHashMap<>();
    public static final WeakHashMap<String, Object> cacheExpression = new WeakHashMap<>();

    private static final ScheduledExecutorService cacheClearTaskScheduler = Executors.newSingleThreadScheduledExecutor();
    private static final Runnable cacheClearTask = new Runnable() {
        public int classesCount = cashedClasses.size();

        @Override
        public void run() {
//            if(cashedClasses.size()-classesCount>0){
//                System.out.println("[CM] Starting clear cache");
//                classesCount = 0;
                cashedClasses.clear();
//                System.gc();
//            }else classesCount = cashedClasses.size();
        }
    };

    public static void saveCache(Object value, int clazzId) {
        cashedClasses.put(value, clazzId);
    }

    public static void clearCache() {
        cacheClearTaskScheduler.execute(cacheClearTask);
    }

    static {
//        cacheClearTaskScheduler.scheduleAtFixedRate(cacheClearTask, 0,1, TimeUnit.NANOSECONDS);
    }
}
