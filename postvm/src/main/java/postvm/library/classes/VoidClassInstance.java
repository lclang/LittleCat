package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.Utils;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;

public final class VoidClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "void",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return INSTANCE.classId;
        }
    };

    public static final VoidClassInstance INSTANCE = new VoidClassInstance();
    public static final Link value = INSTANCE.createLink();

    private VoidClassInstance() {
        super(Caller.CALLER_NONE, PROTOTYPE);
    }

    @Override
    public String toString(int caller) throws LCLangRuntimeException {
        return "";
    }
}
