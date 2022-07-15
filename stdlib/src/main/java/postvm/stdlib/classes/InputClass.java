package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Input",
            ObjectClass.PROTOTYPE,
            Utils.listOf(CallableType.get(NumberClass.PROTOTYPE.type))
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            Method method = PostVMClass.instances.get(args[0]).cast(Method.class);
            return new InputClass(caller, new InputStream() {
                @Override
                public int read() {
                    return PostVMClass.instances.get(method.call(caller, new int[0])).cast(NumberClass.class).value.intValue();
                }
            }).classId;
        }
    };

    public BufferedReader reader;

    public InputClass(Caller caller, InputStream input) {
        super(caller, PROTOTYPE);
        reader = new BufferedReader(new InputStreamReader(input));
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "ready":
                return method(BoolClass.PROTOTYPE.type, (caller, lcClasses) -> {
                    try {
                        return BoolClass.get(reader.ready());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });

            case "read":
                return method(NumberClass.TYPE, (caller, lcClasses) -> {
                    try {
                        return NumberClass.get(reader.read());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });

            case "readLine":
                return method(StringClass.type, (caller, lcClasses) -> {
                    try {
                        String line = reader.readLine();
                        if (line == null) return NullClass.INSTANCE.classId;
                        return StringClass.get(line);
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });

            case "close":
                return voidMethod((caller, lcClasses) -> {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });
        }
        return super.loadGlobal(clazz, target);
    }
}
