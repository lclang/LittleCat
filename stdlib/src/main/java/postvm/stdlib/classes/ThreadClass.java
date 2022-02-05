package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Thread", PostVMClass.PROTOTYPE, Utils.listOf(
            CallableType.get(VoidClass.PROTOTYPE.type))
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return new ThreadClass(caller, args.get(0).cast(Method.class));
        }
    };

    private final AtomicReference<Caller> threadCaller = new AtomicReference<>();
    public Thread thread;

    private ThreadClass(Caller caller, Method method) {
        super(caller, PROTOTYPE);

        thread = new Thread(() -> method.call(threadCaller.get(), Collections.emptyList()));
        thread.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("unhandled exception");
            exception.printStackTrace();
        });
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "start": return voidMethod((caller, args) -> {
                try {
                    threadCaller.set(caller);
                    thread.start();
                }catch (OutOfMemoryError e) {
                    throw new LCLangRuntimeException("PostVM", "Out of memory", caller);
                }
            });

            case "setName": return voidMethod((caller, args) -> thread.setName(
                    args.get(0).cast(StringClass.class).string), StringClass.type);

            case "setPriority": return voidMethod((caller, args) -> thread.setPriority(
                    args.get(0).cast(NumberClass.class).value.intValue()), NumberClass.TYPE);

            case "setDaemon": return voidMethod((caller, args) -> thread.setDaemon(
                    args.get(0)== BoolClass.TRUE), BoolClass.type);

            case "getId": return method((caller, args) -> LongClass.get(thread.getId()),
                    LongClass.TYPE);

            case "getPriority": return method((caller, args) -> IntClass.get(thread.getPriority()),
                    IntClass.TYPE);

            case "getName": return method((caller, args) -> StringClass.get(thread.getName()),
                    StringClass.type);

            case "isDaemon": return method((caller, args) -> BoolClass.get(thread.isDaemon()),
                    BoolClass.type);

            case "isAlive": return method((caller, args) -> BoolClass.get(thread.isAlive()),
                    BoolClass.type);

            case "isInterrupted": return method((caller, args) -> BoolClass.get(thread.isInterrupted()),
                    BoolClass.type);
        }

        return super.loadGlobal(target);
    }
}
