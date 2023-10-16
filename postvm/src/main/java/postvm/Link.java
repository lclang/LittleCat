package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.classes.PostVMClassInstance;

public class Link {
    public final int classId;
    public int state;

    public Link(int classId) {
        this(classId, State.NOTHING);
    }

    public Link(int classId, int state) {
        this.classId = classId;
        this.state = state;
    }

    public PostVMClassInstance get() {
        return PostVMClassInstance.instances.get(classId);
    }

    public void set(int caller, int value) throws LCLangRuntimeException {
        throw new LCLangRuntimeException(
                "Invalid operation",
                "Value is not settable",
                caller);
    }

    public static class State {
        public static final int NOTHING = 0;
        public static final int RETURN = 1;
        public static final int STOP = 2;
    }
}
