package postvm.stdlib.classes;

import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
import postvm.methods.MethodInstance;
import postvm.types.CallableType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Input",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(CallableType.get(NumberClassInstance.PROTOTYPE.type))
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            MethodInstance method = PostVMClassInstance.instances.get(args[0]).cast(MethodInstance.class);
            return new InputClassInstance(caller, new InputStream() {
                @Override
                public int read() {
                    return PostVMClassInstance.instances.get(method.call(caller, new int[0])).cast(NumberClassInstance.class).value.intValue();
                }
            }).classId;
        }
    };

    public BufferedReader reader;

    public InputClassInstance(int caller, InputStream input) {
        super(caller, PROTOTYPE);
        reader = new BufferedReader(new InputStreamReader(input));
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "ready":
                return method(BoolClassInstance.PROTOTYPE.type, (caller, lcClasses) -> {
                    try {
                        return BoolClassInstance.get(reader.ready());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });

            case "read":
                return method(NumberClassInstance.TYPE, (caller, lcClasses) -> {
                    try {
                        return NumberClassInstance.get(reader.read());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });

            case "readLine":
                return method(StringClassInstance.type, (caller, lcClasses) -> {
                    try {
                        String line = reader.readLine();
                        if (line == null) return NullClassInstance.INSTANCE.classId;
                        return StringClassInstance.get(line);
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
        return super.loadMethod(clazz, target);
    }
}
