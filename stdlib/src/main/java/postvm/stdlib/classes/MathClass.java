package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.ObjectClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.library.classes.numbers.NumberClass;

public class MathClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Math", ObjectClass.PROTOTYPE, Utils.listOf()) {
        @Override
        public int createClass(Caller caller, Integer[] args) {
            return INSTANCE.classId;
        }
    };

    public static final MathClass INSTANCE = new MathClass();


    private MathClass() {
        super(null, PROTOTYPE);
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "sqrt": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.sqrt(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "ln": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.log10(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "log": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.log(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "abs": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.abs(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "arccos": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.acos(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "arcsin": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.asin(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "arctan": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.atan(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "sin": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.sin(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "cos": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.cos(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "tan": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.tan(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "rint": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.rint(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "round": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.round(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "floor": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.floor(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "ceil": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.ceil(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "cbrt": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.cbrt(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "exp": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.exp(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "toRadians": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.toRadians(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "toDegrees": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.toDegrees(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "cosh": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.cosh(args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE);
            case "min": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.min(args[0].cast(NumberClass.class).value.doubleValue(),
                                    args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "max": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.max(args[0].cast(NumberClass.class).value.doubleValue(),
                                    args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "copySign": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.copySign(args[0].cast(NumberClass.class).value.doubleValue(),
                                    args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "hypot": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.hypot(args[0].cast(NumberClass.class).value.doubleValue(),
                                    args[0].cast(NumberClass.class).value.doubleValue())),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "floorDiv": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.floorDiv(args[0].cast(NumberClass.class).value.longValue(),
                                    args[0].cast(NumberClass.class).value.longValue())),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "floorMod": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(
                            Math.floorMod(args[0].cast(NumberClass.class).value.longValue(),
                                    args[0].cast(NumberClass.class).value.longValue())),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "random": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(Math.random()));
        }
        return super.loadGlobal(clazz, target);
    }
}
