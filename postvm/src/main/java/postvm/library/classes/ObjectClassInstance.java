package postvm.library.classes;

import postvm.Caller;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.types.Type;

import java.util.Collections;

public class ObjectClassInstance extends PostVMClassInstance {
    public final static PostVMClassPrototype<ObjectClassInstance> PROTOTYPE = new PostVMClassPrototype<>(
            "object",
            null,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new ObjectClassInstance().classId;
        }
    };

    public static Type OBJECT_TYPE = PROTOTYPE.type;

    public ObjectClassInstance() {
        super(Caller.CALLER_NONE, PROTOTYPE, new int[0]);
    }
}
