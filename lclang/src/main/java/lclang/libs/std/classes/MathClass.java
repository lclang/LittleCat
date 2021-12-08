package lclang.libs.std.classes;

import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.NumberClass;
import lclang.types.Type;

public class MathClass extends LibraryClass {
    public static final String name = "Math";
    public static final MathClass instance = new MathClass();
    public static final Type type = instance.classType;

    private MathClass() {
        super(name);
        globals.put("sqrt", method((caller, args) -> DoubleClass.get(
                Math.sqrt(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("ln", method((caller, args) -> DoubleClass.get(
                Math.log10(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("log", method((caller, args) -> DoubleClass.get(
                Math.log(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("abs", method((caller, args) -> DoubleClass.get(
                Math.abs(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("arccos", method((caller, args) -> DoubleClass.get(
                Math.acos(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("arcsin", method((caller, args) -> DoubleClass.get(
                Math.asin(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("arctan", method((caller, args) -> DoubleClass.get(
                Math.atan(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("sin", method((caller, args) -> DoubleClass.get(
                Math.sin(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("cos", method((caller, args) -> DoubleClass.get(
                Math.cos(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("tan", method((caller, args) -> DoubleClass.get(
                Math.tan(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("rint", method((caller, args) -> DoubleClass.get(
                Math.rint(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("round", method((caller, args) -> DoubleClass.get(
                Math.round(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("floor", method((caller, args) -> DoubleClass.get(
                Math.floor(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("ceil", method((caller, args) -> DoubleClass.get(
                Math.ceil(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("cbrt", method((caller, args) -> DoubleClass.get(
                Math.cbrt(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("exp", method((caller, args) -> DoubleClass.get(
                Math.exp(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("toRadians", method((caller, args) -> DoubleClass.get(
                Math.toRadians(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("toDegrees", method((caller, args) -> DoubleClass.get(
                Math.toDegrees(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("cosh", method((caller, args) -> DoubleClass.get(
                Math.cosh(args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("min", method((caller, args) -> DoubleClass.get(
                Math.min(args.get(0).cast(NumberClass.class).number.doubleValue(),
                        args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("max", method((caller, args) -> DoubleClass.get(
                Math.max(args.get(0).cast(NumberClass.class).number.doubleValue(),
                        args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("copySign", method((caller, args) -> DoubleClass.get(
                Math.copySign(args.get(0).cast(NumberClass.class).number.doubleValue(),
                        args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("hypot", method((caller, args) -> DoubleClass.get(
                Math.hypot(args.get(0).cast(NumberClass.class).number.doubleValue(),
                        args.get(0).cast(NumberClass.class).number.doubleValue())),
                NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("floorDiv", method((caller, args) -> DoubleClass.get(
                Math.floorDiv(args.get(0).cast(NumberClass.class).number.longValue(),
                        args.get(0).cast(NumberClass.class).number.longValue())),
                NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("floorMod", method((caller, args) -> DoubleClass.get(
                Math.floorMod(args.get(0).cast(NumberClass.class).number.longValue(),
                        args.get(0).cast(NumberClass.class).number.longValue())),
                NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE));

        globals.put("random", method((caller, args) -> DoubleClass.get(Math.random()), DoubleClass.TYPE));
    }
}
