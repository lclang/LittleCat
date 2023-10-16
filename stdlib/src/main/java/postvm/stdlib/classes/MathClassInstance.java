package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.LibraryClassInstance;
import postvm.library.classes.ObjectClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.NumberClassInstance;

public class MathClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Math", ObjectClassInstance.PROTOTYPE, Utils.listOf()) {
        @Override
        public int createClass(int caller, int[] args) {
            return INSTANCE.classId;
        }
    };

    public static final MathClassInstance INSTANCE = new MathClassInstance();


    private MathClassInstance() {
        super(Caller.CALLER_NONE, PROTOTYPE);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "sqrt": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.sqrt(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "ln": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.log10(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "log": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.log(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "abs": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.abs(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "arccos": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.acos(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "arcsin": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.asin(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "arctan": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.atan(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "sin": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.sin(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "cos": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.cos(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "tan": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.tan(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "rint": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.rint(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "round": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.round(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "floor": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.floor(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "ceil": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.ceil(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "cbrt": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.cbrt(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "exp": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.exp(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "toRadians": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.toRadians(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "toDegrees": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.toDegrees(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "cosh": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.cosh(args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE);
            case "min": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.min(args[0].cast(NumberClassInstance.class).value.doubleValue(),
                                    args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "max": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.max(args[0].cast(NumberClassInstance.class).value.doubleValue(),
                                    args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "copySign": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.copySign(args[0].cast(NumberClassInstance.class).value.doubleValue(),
                                    args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "hypot": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.hypot(args[0].cast(NumberClassInstance.class).value.doubleValue(),
                                    args[0].cast(NumberClassInstance.class).value.doubleValue())),
                    NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "floorDiv": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.floorDiv(args[0].cast(NumberClassInstance.class).value.longValue(),
                                    args[0].cast(NumberClassInstance.class).value.longValue())),
                    NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "floorMod": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(
                            Math.floorMod(args[0].cast(NumberClassInstance.class).value.longValue(),
                                    args[0].cast(NumberClassInstance.class).value.longValue())),
                    NumberClassInstance.TYPE, NumberClassInstance.TYPE);
            case "random": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(Math.random()));
        }
        return super.loadMethod(clazz, target);
    }
}
