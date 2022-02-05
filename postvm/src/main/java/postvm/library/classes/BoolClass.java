package postvm.library.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.types.Type;

import java.util.List;
import java.util.Objects;

public final class BoolClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "bool",
            PostVMClass.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return FALSE;
        }
    };

    public static final Type type = PROTOTYPE.type;

    public static final BoolClass TRUE = new BoolClass(true);
    public static final BoolClass FALSE = new BoolClass(false);

    public boolean bool;

    private BoolClass(boolean bool) {
        super(null, PROTOTYPE);
        this.bool = bool;
    }

    public BoolClass not() {
        return get(!bool);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        if(target.equals("toString")) return method((caller, lcClasses) ->
                StringClass.get(String.valueOf(bool)), StringClass.type);
        return super.loadGlobal(target);
    }

    public static BoolClass get(boolean bool) {
        return bool ? TRUE: FALSE;
    }
}
