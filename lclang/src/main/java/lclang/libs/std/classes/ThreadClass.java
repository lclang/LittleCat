package lclang.libs.std.classes;

import lclang.Caller;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.LongClass;
import lclang.libs.lang.classes.numbers.NumberClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Types;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadClass extends LibraryClass {
    public static final String name = "Thread";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final ThreadClass instance = new ThreadClass();
    public Thread thread;

    private ThreadClass() {
        super(name);
        constructor = method((caller, lcClasses) -> new ThreadClass((Method) lcClasses.get(0)),
                CallableType.get(Types.VOID), type);
    }

    private ThreadClass(Method method) {
        this();

        AtomicReference<Caller> threadCaller = new AtomicReference<>();
        thread = new Thread(() -> {
            try {
                method.call(threadCaller.get(), Collections.emptyList());
            } catch (LCLangRuntimeException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setUncaughtExceptionHandler((thread, exception) -> exception.printStackTrace());

        globals.put("start", voidMethod((caller, lcClasses) -> {
            threadCaller.set(caller);
            thread.start();
        }).asValue());

        globals.put("setName", voidMethod((caller, lcClasses) -> thread.setName(
                lcClasses.get(0).toString(caller)), StringClass.type).asValue());
        globals.put("setPriority", voidMethod((caller, lcClasses) -> thread.setPriority(
                ((NumberClass) lcClasses.get(0)).number.intValue()), NumberClass.type).asValue());
        globals.put("setDaemon", voidMethod((caller, lcClasses) -> thread.setDaemon(
                ((BoolClass) lcClasses.get(0)).bool), BoolClass.type).asValue());

        globals.put("getId", method((caller, lcClasses) -> LongClass.get(thread.getId()),
                LongClass.type).asValue());
        globals.put("getPriority", method((caller, lcClasses) -> IntClass.get(thread.getPriority()),
                IntClass.type).asValue());
        globals.put("getName", method((caller, lcClasses) -> StringClass.get(thread.getName()),
                StringClass.type).asValue());
        globals.put("isDaemon", method((caller, lcClasses) -> BoolClass.get(thread.isDaemon()),
                BoolClass.type).asValue());
        globals.put("isAlive", method((caller, lcClasses) -> BoolClass.get(thread.isAlive()),
                BoolClass.type).asValue());
        globals.put("isInterrupted", method((caller, lcClasses) -> BoolClass.get(thread.isInterrupted()),
                BoolClass.type).asValue());
    }
}
