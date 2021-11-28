package lclang.libs.std.classes;

import lclang.LCClass;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.ArrayClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Types;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

public class OutputClass extends LibraryClass {
    public static final String name = "Output";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final OutputClass instance = new OutputClass();
    public PrintStream printer;

    private OutputClass() {
        super(name);

        constructor = method((caller, lcClasses) -> {
            Method method = (Method) lcClasses.get(0);
            return new OutputClass(new OutputStream() {
                @Override
                public void write(int b) {
                    try {
                        method.call(caller, Collections.singletonList(IntClass.get(b).asValue()))
                                .get.invoke(caller);
                    } catch (LCLangRuntimeException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }, CallableType.get(IntClass.type, Types.VOID), type);
    }

    public OutputClass(OutputStream stream) {
        this();
        printer = new PrintStream(stream);

        globals.put("flush", voidMethod((caller, lcClasses) -> printer.flush()).asValue());
        globals.put("close", voidMethod((caller, lcClasses) -> printer.close()).asValue());
        globals.put("accept", voidMethod((caller, lcClasses) -> {
            InputClass input = (InputClass) lcClasses.get(0);
            while (input.scanner.hasNextLine())
                printer.println(input.scanner.nextLine());

        }, InputClass.type).asValue());

        globals.put("print", voidMethod((caller, lcClasses) ->
                printer.print(lcClasses.get(0).toString(caller)), Types.ANY).asValue());
        globals.put("println", voidMethod((caller, lcClasses) ->
                printer.println(lcClasses.get(0).toString(caller)), Types.ANY).asValue());
        globals.put("printf", voidMethod((caller, lcClasses) -> {
            String main = lcClasses.get(0).toString(caller);
            List<LCClass> classes = ((ArrayClass) lcClasses.get(1)).value;
            String[] args = new String[classes.size()];
            for (int i = 0; i < classes.size(); i++) {
                args[i] = classes.get(i).toString(caller);
            }

            printer.printf(main, (Object[]) args);
        }, Types.ANY, ArrayClass.type).asValue());
    }
}
