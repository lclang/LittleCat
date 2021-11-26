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
        }, CallableType.get(Types.INT), type);
    }

    public InputClass(InputStream input) {
        this();
        scanner = new Scanner(input);
        globals.put("hasNextLine", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextLine()), Types.BOOL).asValue());
        globals.put("hasNextInt", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextInt()), Types.BOOL).asValue());
        globals.put("hasNextByte", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextByte()), Types.BOOL).asValue());
        globals.put("hasNextLong", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextLong()), Types.BOOL).asValue());
        globals.put("hasNextDouble", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextDouble()), Types.BOOL).asValue());
        globals.put("hasNext", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNext()), Types.BOOL).asValue());

        globals.put("readLine", method((caller, lcClasses) ->
                StringClass.get(scanner.nextLine()), Types.STRING).asValue());
        globals.put("readInt", method((caller, lcClasses) ->
                IntClass.get(scanner.nextInt()), Types.INT).asValue());
        globals.put("readByte", method((caller, lcClasses) ->
                LongClass.get(scanner.nextByte()), Types.LONG).asValue());
        globals.put("readLong", method((caller, lcClasses) ->
                LongClass.get(scanner.nextLong()), Types.LONG).asValue());
        globals.put("readDouble", method((caller, lcClasses) ->
                DoubleClass.get(scanner.nextDouble()), Types.DOUBLE).asValue());
        globals.put("read", method((caller, lcClasses) ->
                StringClass.get(scanner.next()), Types.STRING).asValue());

        globals.put("close", voidMethod((caller, lcClasses) -> scanner.close()).asValue());
    }
}
