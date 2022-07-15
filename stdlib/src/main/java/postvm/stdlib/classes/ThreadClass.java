package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;

import java.util.concurrent.atomic.AtomicReference;

public class ThreadClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Thread", ObjectClass.PROTOTYPE, Utils.listOf(
            CallableType.get(VoidClass.PROTOTYPE.type))
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            return new ThreadClass(caller, (Method) PostVMClass.instances.get(args[0])).classId;
        }
    };

    private final AtomicReference<Caller> threadCaller = new AtomicReference<>();
    public Thread thread;

    private ThreadClass(Caller caller, Method method) {
        super(caller, PROTOTYPE);

        thread = new Thread(() -> method.call(threadCaller.get(), new int[0]));
        thread.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("unhandled exception");
            exception.printStackTrace();
        });
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
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
                    args[0].cast(StringClass.class).string), StringClass.type);
            case "setPriority": return voidMethod((caller, args) -> thread.setPriority(
                    args[0].cast(NumberClass.class).value.intValue()), NumberClass.TYPE);
            case "setDaemon": return voidNativeMethod((caller, args) -> thread.setDaemon(args[0]==BoolClass.TRUE), BoolClass.type);
            case "getId": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(thread.getId()));
            case "getPriority": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(thread.getPriority()));
            case "getName": return method(StringClass.type, (caller, args) -> StringClass.get(thread.getName()));
            case "isDaemon": return method(BoolClass.type, (caller, args) -> BoolClass.get(thread.isDaemon()));
            case "isAlive": return method(BoolClass.type, (caller, args) -> BoolClass.get(thread.isAlive()));
            case "isInterrupted": return method(BoolClass.type, (caller, args) -> BoolClass.get(thread.isInterrupted()));
        }

        return super.loadGlobal(clazz, target);
    }
}
