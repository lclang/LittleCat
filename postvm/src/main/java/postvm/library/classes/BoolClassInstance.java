package postvm.library.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.types.Type;

public final class BoolClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "bool",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return FALSE;
        }
    };

    public static final Type type = PROTOTYPE.type;

    public static final int TRUE = new BoolClassInstance().classId;
    public static final int FALSE = new BoolClassInstance().classId;


    private BoolClassInstance() {
        super(Caller.CALLER_NONE, PROTOTYPE);
    }
    public static int not(int classId) {
        return classId == TRUE? FALSE: TRUE;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        if(target.equals("toString")) return toStrMethod((caller) -> StringClassInstance.get(this.classId == TRUE ? "true": "false"));
        return super.loadMethod(clazz, target);
    }

    public static int get(boolean bool) {
        return bool ? TRUE: FALSE;
    }
}
