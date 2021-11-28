package lclang.libs.std.classes;

import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.NumberClass;
import lclang.types.Types;

public class MathClass extends LibraryClass {
    public static final String name = "Math";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final MathClass instance = new MathClass();

    private MathClass() {
        super(name);
        globals.put("sqrt", method((caller, lcClasses) -> DoubleClass.get(
                Math.sqrt(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("ln", method((caller, lcClasses) -> DoubleClass.get(
                Math.log10(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("log", method((caller, lcClasses) -> DoubleClass.get(
                Math.log(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("abs", method((caller, lcClasses) -> DoubleClass.get(
                Math.abs(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("arccos", method((caller, lcClasses) -> DoubleClass.get(
                Math.acos(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("arcsin", method((caller, lcClasses) -> DoubleClass.get(
                Math.asin(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("arctan", method((caller, lcClasses) -> DoubleClass.get(
                Math.atan(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("sin", method((caller, lcClasses) -> DoubleClass.get(
                Math.sin(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("cos", method((caller, lcClasses) -> DoubleClass.get(
                Math.cos(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("tan", method((caller, lcClasses) -> DoubleClass.get(
                Math.tan(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("rint", method((caller, lcClasses) -> DoubleClass.get(
                Math.rint(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("round", method((caller, lcClasses) -> DoubleClass.get(
                Math.round(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("floor", method((caller, lcClasses) -> DoubleClass.get(
                Math.floor(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("ceil", method((caller, lcClasses) -> DoubleClass.get(
                Math.ceil(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("cbrt", method((caller, lcClasses) -> DoubleClass.get(
                Math.cbrt(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("exp", method((caller, lcClasses) -> DoubleClass.get(
                Math.exp(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("toRadians", method((caller, lcClasses) -> DoubleClass.get(
                Math.toRadians(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("toDegrees", method((caller, lcClasses) -> DoubleClass.get(
                Math.toDegrees(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("cosh", method((caller, lcClasses) -> DoubleClass.get(
                Math.cosh(((NumberClass) lcClasses.get(0)).number.doubleValue())),
                NumberClass.type, DoubleClass.type).asValue());

        globals.put("min", method((caller, lcClasses) -> DoubleClass.get(
                Math.min(((NumberClass) lcClasses.get(0)).number.doubleValue(),
                        ((NumberClass) lcClasses.get(1)).number.doubleValue())),
                NumberClass.type, NumberClass.type, DoubleClass.type).asValue());

        globals.put("max", method((caller, lcClasses) -> DoubleClass.get(
                Math.max(((NumberClass) lcClasses.get(0)).number.doubleValue(),
                        ((NumberClass) lcClasses.get(1)).number.doubleValue())),
                NumberClass.type, NumberClass.type, DoubleClass.type).asValue());

        globals.put("copySign", method((caller, lcClasses) -> DoubleClass.get(
                Math.copySign(((NumberClass) lcClasses.get(0)).number.doubleValue(),
                        ((NumberClass) lcClasses.get(1)).number.doubleValue())),
                NumberClass.type, NumberClass.type, DoubleClass.type).asValue());

        globals.put("hypot", method((caller, lcClasses) -> DoubleClass.get(
                Math.hypot(((NumberClass) lcClasses.get(0)).number.doubleValue(),
                        ((NumberClass) lcClasses.get(1)).number.doubleValue())),
                NumberClass.type, NumberClass.type, DoubleClass.type).asValue());

        globals.put("floorDiv", method((caller, lcClasses) -> DoubleClass.get(
                Math.floorDiv(((NumberClass) lcClasses.get(0)).number.longValue(),
                        ((NumberClass) lcClasses.get(1)).number.longValue())),
                NumberClass.type, NumberClass.type, DoubleClass.type).asValue());

        globals.put("floorMod", method((caller, lcClasses) -> DoubleClass.get(
                Math.floorMod(((NumberClass) lcClasses.get(0)).number.longValue(),
                        ((NumberClass) lcClasses.get(1)).number.longValue())),
                NumberClass.type, NumberClass.type, DoubleClass.type).asValue());

        globals.put("random", method((caller, lcClasses) -> DoubleClass.get(Math.random()), DoubleClass.type).asValue());
    }
}
