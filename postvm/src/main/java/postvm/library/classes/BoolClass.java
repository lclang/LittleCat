package postvm.library.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.types.Type;

public final class BoolClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "bool",
            ObjectClass.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            return FALSE;
        }
    };

    public static final Type type = PROTOTYPE.type;

    public static final int TRUE = new BoolClass().classId;
    public static final int FALSE = new BoolClass().classId;


    private BoolClass() {
        super(null, PROTOTYPE);
    }
    public static int not(int classId) {
        return classId == TRUE? FALSE: TRUE;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        if(target.equals("toString")) return toStrMethod((caller) -> StringClass.get(this.classId == TRUE ? "true": "false"));
        return super.loadGlobal(clazz, target);
    }

    public static int get(boolean bool) {
        return bool ? TRUE: FALSE;
    }
}
