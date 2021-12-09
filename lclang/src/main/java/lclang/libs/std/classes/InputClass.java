package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.NullClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Type;

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
                    return ((IntClass) method.call(caller, Collections.emptyList())).value;
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
