package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.types.Type;

import java.util.List;

public final class VoidClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "void",
            ObjectClass.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public int createClass(Caller caller, Integer[] args) {
            return INSTANCE.classId;
        }
    };

    public static final VoidClass INSTANCE = new VoidClass();
    public static final Link value = INSTANCE.createLink();

    private VoidClass() {
        super(null, PROTOTYPE);
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return "";
    }
}
