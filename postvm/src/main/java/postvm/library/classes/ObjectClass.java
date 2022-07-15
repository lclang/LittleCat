package postvm.library.classes;

import postvm.Caller;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

import java.util.Collections;

public class ObjectClass extends PostVMClass {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "object",
            null,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(Caller caller, Integer[] args) {
            return new ObjectClass().classId;
        }
    };

    public static Type OBJECT_TYPE = PROTOTYPE.type;

    public ObjectClass() {
        super(null, PROTOTYPE, new Integer[0]);
    }
}
