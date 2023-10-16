package postvm.library.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.classes.PostVMClassPrototype;

public final class NullClassInstance extends LibraryClassInstance {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "null",
            null,
            Utils.listOf()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return INSTANCE.classId;
        }
    };

    public static final NullClassInstance INSTANCE = new NullClassInstance();

    private NullClassInstance() {
        super(Caller.CALLER_NONE, PROTOTYPE);
    }

    @Override
    public String toString(int caller) {
        return "null";
    }
}
