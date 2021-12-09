package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.ArrayClass;
import lclang.libs.lang.classes.LCClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.VoidClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.NumberClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Type;
import lclang.types.Types;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

public class OutputClass extends LibraryClass {
    public static final String name = "Output";
    public static final OutputClass instance = new OutputClass();
    public static final Type type = instance.classType;
    public PrintStream printer;

    private OutputClass() {
        super(name);

        constructor = method((caller, args) -> {
            Method method = (Method) args.get(0);
            return new OutputClass(new OutputStream() {
                @Override
                public void write(int b) {
                    method.call(caller, Collections.singletonList(IntClass.get(b)));
                }
            });
        }, CallableType.get(IntClass.TYPE, VoidClass.type), type);
    }

    public OutputClass(OutputStream stream) {
        this();
        try {
            printer = new PrintStream(stream, false, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {}

        globals.put("flush", voidMethod((caller, args) -> printer.flush()));
        globals.put("close", voidMethod((caller, args) -> printer.close()));
        globals.put("accept", voidMethod((caller, args) -> {
            InputClass input = (InputClass) args.get(0);

            try {
                String line;
                while ((line = input.reader.readLine())!=null)
                    printer.println(line);
            }catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }

        }, InputClass.type));

        globals.put("write", voidMethod((caller, args) -> printer.write(args.get(0)
                .cast(NumberClass.class)
                        .number.byteValue()), NumberClass.TYPE));
        globals.put("print", voidMethod((caller, args) ->
                printer.print(args.get(0).toString(caller)), Types.ANY));
        globals.put("println", voidMethod((caller, args) ->
                printer.println(args.get(0).toString(caller)), Types.ANY));
        globals.put("printf", voidMethod((caller, args) -> {
            String main = args.get(0).toString(caller);
            List<LCClass> classes = ((ArrayClass) args.get(1)).value;
            String[] printArgs = new String[classes.size()];
            for (int i = 0; i < classes.size(); i++) {
                printArgs[i] = classes.get(i).toString(caller);
            }

            printer.printf(main, (Object[]) printArgs);
        }, Types.ANY, ArrayClass.type));
    }
}
