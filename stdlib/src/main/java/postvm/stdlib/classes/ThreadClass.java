package postvm.stdlib.classes;

import postvm.Caller;
import postvm.library.classes.BoolClass;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.StringClass;
import postvm.library.classes.VoidClass;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadClass extends LibraryClass {
    public static final String name = "Thread";
    public static final ThreadClass instance = new ThreadClass();
    public static final Type type = instance.classType;
    public Thread thread;

    private ThreadClass() {
        super(name);
        constructor = method((caller, args) -> new ThreadClass((Method) args.get(0)),
                CallableType.get(VoidClass.type), type);
    }

    private ThreadClass(Method method) {
        this();

        AtomicReference<Caller> threadCaller = new AtomicReference<>();
        thread = new Thread(() -> method.call(threadCaller.get(), Collections.emptyList()));

        thread.setUncaughtExceptionHandler((thread, exception) -> exception.printStackTrace());

        globals.put("start", voidMethod((caller, args) -> {
            threadCaller.set(caller);
            thread.start();
        }));

        globals.put("setName", voidMethod((caller, args) -> thread.setName(
                args.get(0).cast(StringClass.class).string), StringClass.type));
        globals.put("setPriority", voidMethod((caller, args) -> thread.setPriority(
                args.get(0).cast(NumberClass.class).value.intValue()), NumberClass.TYPE));
        globals.put("setDaemon", voidMethod((caller, args) -> thread.setDaemon(
                args.get(0)== BoolClass.TRUE), BoolClass.type));

        globals.put("getId", method((caller, args) -> LongClass.get(thread.getId()),
                LongClass.TYPE));
        globals.put("getPriority", method((caller, args) -> IntClass.get(thread.getPriority()),
                IntClass.TYPE));
        globals.put("getName", method((caller, args) -> StringClass.get(thread.getName()),
                StringClass.type));
        globals.put("isDaemon", method((caller, args) -> BoolClass.get(thread.isDaemon()),
                BoolClass.type));
        globals.put("isAlive", method((caller, args) -> BoolClass.get(thread.isAlive()),
                BoolClass.type));
        globals.put("isInterrupted", method((caller, args) -> BoolClass.get(thread.isInterrupted()),
                BoolClass.type));
    }
}
