package postvm.stdlib.classes;

import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
import postvm.methods.MethodInstance;
import postvm.types.CallableType;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Thread", ObjectClassInstance.PROTOTYPE, Utils.listOf(
            CallableType.get(VoidClassInstance.PROTOTYPE.type))
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new ThreadClassInstance(caller, (MethodInstance) PostVMClassInstance.instances.get(args[0])).classId;
        }
    };

    private final AtomicInteger threadCaller = new AtomicInteger();
    public Thread thread;

    private ThreadClassInstance(int caller, MethodInstance method) {
        super(caller, PROTOTYPE);

        thread = new Thread(() -> method.call(threadCaller.get(), new int[0]));
        thread.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("unhandled exception");
            exception.printStackTrace();
        });
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
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
                    args[0].cast(StringClassInstance.class).string), StringClassInstance.type);
            case "setPriority": return voidMethod((caller, args) -> thread.setPriority(
                    args[0].cast(NumberClassInstance.class).value.intValue()), NumberClassInstance.TYPE);
            case "setDaemon": return voidNativeMethod((caller, args) -> thread.setDaemon(args[0]== BoolClassInstance.TRUE), BoolClassInstance.type);
            case "getId": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(thread.getId()));
            case "getPriority": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(thread.getPriority()));
            case "getName": return method(StringClassInstance.type, (caller, args) -> StringClassInstance.get(thread.getName()));
            case "isDaemon": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(thread.isDaemon()));
            case "isAlive": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(thread.isAlive()));
            case "isInterrupted": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(thread.isInterrupted()));
        }

        return super.loadMethod(clazz, target);
    }
}
