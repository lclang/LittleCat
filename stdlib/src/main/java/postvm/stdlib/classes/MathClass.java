package postvm.stdlib.classes;

import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.numbers.DoubleClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

public class MathClass extends LibraryClass {
    public static final String name = "Math";
    public static final MathClass instance = new MathClass();
    public static final Type type = instance.classType;

    private MathClass() {
        super(name);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "sqrt": return method((caller, args) -> DoubleClass.get(
                            Math.sqrt(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "ln": return method((caller, args) -> DoubleClass.get(
                            Math.log10(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "log": return method((caller, args) -> DoubleClass.get(
                            Math.log(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "abs": return method((caller, args) -> DoubleClass.get(
                            Math.abs(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "arccos": return method((caller, args) -> DoubleClass.get(
                            Math.acos(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "arcsin": return method((caller, args) -> DoubleClass.get(
                            Math.asin(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "arctan": return method((caller, args) -> DoubleClass.get(
                            Math.atan(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "sin": return method((caller, args) -> DoubleClass.get(
                            Math.sin(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "cos": return method((caller, args) -> DoubleClass.get(
                            Math.cos(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "tan": return method((caller, args) -> DoubleClass.get(
                            Math.tan(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "rint": return method((caller, args) -> DoubleClass.get(
                            Math.rint(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "round": return method((caller, args) -> DoubleClass.get(
                            Math.round(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "floor": return method((caller, args) -> DoubleClass.get(
                            Math.floor(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "ceil": return method((caller, args) -> DoubleClass.get(
                            Math.ceil(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "cbrt": return method((caller, args) -> DoubleClass.get(
                            Math.cbrt(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "exp": return method((caller, args) -> DoubleClass.get(
                            Math.exp(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "toRadians": return method((caller, args) -> DoubleClass.get(
                            Math.toRadians(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "toDegrees": return method((caller, args) -> DoubleClass.get(
                            Math.toDegrees(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "cosh": return method((caller, args) -> DoubleClass.get(
                            Math.cosh(args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, DoubleClass.TYPE);
            case "min": return method((caller, args) -> DoubleClass.get(
                            Math.min(args.get(0).cast(NumberClass.class).value.doubleValue(),
                                    args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE);
            case "max": return method((caller, args) -> DoubleClass.get(
                            Math.max(args.get(0).cast(NumberClass.class).value.doubleValue(),
                                    args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE);
            case "copySign": return method((caller, args) -> DoubleClass.get(
                            Math.copySign(args.get(0).cast(NumberClass.class).value.doubleValue(),
                                    args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE);
            case "hypot": return method((caller, args) -> DoubleClass.get(
                            Math.hypot(args.get(0).cast(NumberClass.class).value.doubleValue(),
                                    args.get(0).cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE);
            case "floorDiv": return method((caller, args) -> DoubleClass.get(
                            Math.floorDiv(args.get(0).cast(NumberClass.class).value.longValue(),
                                    args.get(0).cast(NumberClass.class).value.longValue())),
                    NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE);
            case "floorMod": return  method((caller, args) -> DoubleClass.get(
                            Math.floorMod(args.get(0).cast(NumberClass.class).value.longValue(),
                                    args.get(0).cast(NumberClass.class).value.longValue())),
                    NumberClass.TYPE, NumberClass.TYPE, DoubleClass.TYPE);
            case "random": return method((caller, args) -> DoubleClass.get(Math.random()), DoubleClass.TYPE);
        }
        return super.loadGlobal(target);
    }
}
