package lclang.libs.std.classes;

import lclang.exceptions.LCLangException;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.LongClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Types;

import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

public class InputClass extends LibraryClass {
    public static final String name = "Input";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final InputClass instance = new InputClass();
    public Scanner scanner;

    private InputClass() {
        super(name);
        constructor = method((caller, lcClasses) -> {
            Method method = (Method) lcClasses.get(0);
            return new InputClass(new InputStream() {
                @Override
                public int read() {
                    try {
                        return ((IntClass) method.call(caller, Collections.emptyList()).get
                                .invoke(caller)).value;
                    } catch (LCLangException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }, CallableType.get(IntClass.type), type);
    }

    public InputClass(InputStream input) {
        this();
        scanner = new Scanner(input);
        globals.put("hasNextLine", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextLine()), BoolClass.type).asValue());
        globals.put("hasNextInt", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextInt()), BoolClass.type).asValue());
        globals.put("hasNextByte", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextByte()), BoolClass.type).asValue());
        globals.put("hasNextLong", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextLong()), BoolClass.type).asValue());
        globals.put("hasNextDouble", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextDouble()), BoolClass.type).asValue());
        globals.put("hasNext", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNext()), BoolClass.type).asValue());

        globals.put("readLine", method((caller, lcClasses) ->
                StringClass.get(scanner.nextLine()), StringClass.type).asValue());
        globals.put("readInt", method((caller, lcClasses) ->
                IntClass.get(scanner.nextInt()), IntClass.type).asValue());
        globals.put("readByte", method((caller, lcClasses) ->
                LongClass.get(scanner.nextByte()), LongClass.type).asValue());
        globals.put("readLong", method((caller, lcClasses) ->
                LongClass.get(scanner.nextLong()), LongClass.type).asValue());
        globals.put("readDouble", method((caller, lcClasses) ->
                DoubleClass.get(scanner.nextDouble()), DoubleClass.type).asValue());
        globals.put("read", method((caller, lcClasses) ->
                StringClass.get(scanner.next()), StringClass.type).asValue());

        globals.put("close", voidMethod((caller, lcClasses) -> scanner.close()).asValue());
    }
}
