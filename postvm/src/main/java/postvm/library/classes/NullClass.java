package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.Utils;
import postvm.exceptions.LCLangNullPointerException;
import postvm.types.Type;

import java.util.List;

public final class NullClass extends LibraryClass {
    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "null",
            null,
            Utils.listOf()
    ) {
        @Override
        public int createClass(Caller caller, Integer[] args) {
            return INSTANCE.classId;
        }
    };

    public static final NullClass INSTANCE = new NullClass();

    private NullClass() {
        super(null, PROTOTYPE);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }
}
