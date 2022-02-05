package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.DoubleClass;
import postvm.library.classes.numbers.IntClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class InputClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Input",
            PostVMClass.PROTOTYPE,
            Utils.listOf(CallableType.get(IntClass.PROTOTYPE.type))
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            Method method = args.get(0).cast(Method.class);
            return new InputClass(caller, new InputStream() {
                @Override
                public int read() {
                    return method.call(caller, Collections.emptyList()).cast(IntClass.class).value;
                }
            });
        }
    };

    public BufferedReader reader;

    public InputClass(Caller caller, InputStream input) {
        super(caller, PROTOTYPE);
        reader = new BufferedReader(new InputStreamReader(input));
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "ready":
                return method((caller, lcClasses) -> {
                    try {
                        return BoolClass.get(reader.ready());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, DoubleClass.TYPE);

            case "read":
                return method((caller, lcClasses) -> {
                    try {
                        return IntClass.get(reader.read());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, IntClass.TYPE);

            case "readLine":
                return method((caller, lcClasses) -> {
                    try {
                        String line = reader.readLine();
                        if (line == null) return NullClass.INSTANCE;
                        return StringClass.get(line);
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, StringClass.type);

            case "close":
                return voidMethod((caller, lcClasses) -> {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                });
        }
        return super.loadGlobal(target);
    }
}
