package lclang.libs.std.classes;

import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.LongClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Type;

import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

public class InputClass extends LibraryClass {
    public static final String name = "Input";
    public static final InputClass instance = new InputClass();
    public static final Type type = instance.classType;
    public Scanner scanner;

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

        scanner = new Scanner(input);
        globals.put("hasNextLine", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextLine()), BoolClass.type));
        globals.put("hasNextInt", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextInt()), BoolClass.type));
        globals.put("hasNextByte", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextByte()), BoolClass.type));
        globals.put("hasNextLong", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextLong()), BoolClass.type));
        globals.put("hasNextDouble", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNextDouble()), BoolClass.type));
        globals.put("hasNext", method((caller, lcClasses) ->
                BoolClass.get(scanner.hasNext()), BoolClass.type));

        globals.put("readLine", method((caller, lcClasses) ->
                StringClass.get(scanner.nextLine()), StringClass.type));
        globals.put("readInt", method((caller, lcClasses) ->
                IntClass.get(scanner.nextInt()), IntClass.TYPE));
        globals.put("readByte", method((caller, lcClasses) ->
                LongClass.get(scanner.nextByte()), LongClass.TYPE));
        globals.put("readLong", method((caller, lcClasses) ->
                LongClass.get(scanner.nextLong()), LongClass.TYPE));
        globals.put("readDouble", method((caller, lcClasses) ->
                DoubleClass.get(scanner.nextDouble()), DoubleClass.TYPE));
        globals.put("read", method((caller, lcClasses) ->
                StringClass.get(scanner.next()), StringClass.type));

        globals.put("close", voidMethod((caller, lcClasses) -> scanner.close()));
    }
}
