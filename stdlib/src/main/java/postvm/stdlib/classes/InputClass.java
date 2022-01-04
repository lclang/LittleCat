package postvm.stdlib.classes;

import postvm.exceptions.LCLangIOException;
import postvm.library.classes.BoolClass;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.NullClass;
import postvm.library.classes.StringClass;
import postvm.library.classes.numbers.DoubleClass;
import postvm.library.classes.numbers.IntClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;

public class InputClass extends LibraryClass {
    public static final String name = "Input";
    public static final InputClass instance = new InputClass();
    public static final Type type = instance.classType;
    public BufferedReader reader;

    private InputClass() {
        super(name);
        constructor = method((caller, lcClasses) -> {
            Method method = (Method) lcClasses.get(0);
            return new InputClass(new InputStream() {
                @Override
                public int read() {
                    return method.call(caller, Collections.emptyList()).cast(IntClass.class).value
                            .intValue();
                }
            });
        }, CallableType.get(IntClass.TYPE), type);
    }

    public InputClass(InputStream input) {
        this();

        reader = new BufferedReader(new InputStreamReader(input));
        globals.put("readLine", method((caller, lcClasses) ->
        {
            try {
                String line = reader.readLine();
                if(line==null) return NullClass.instance;
                return StringClass.get(line);
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, StringClass.type));

        globals.put("ready", method((caller, lcClasses) ->
        {
            try {
                return BoolClass.get(reader.ready());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, DoubleClass.TYPE));

        globals.put("read", method((caller, lcClasses) ->
        {
            try {
                return IntClass.get(reader.read());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, IntClass.TYPE));

        globals.put("close", voidMethod((caller, lcClasses) -> {
            try {
                reader.close();
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }));
    }
}