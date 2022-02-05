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
                PostVMClass.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return INSTANCE;
        }
    };

    public static final NullClass INSTANCE = new NullClass();

    private NullClass() {
        super(null, PROTOTYPE);
    }

    @Override
    public PostVMClass getVariableClass(Caller caller, String name) throws LCLangNullPointerException {
        throw new LCLangNullPointerException(caller);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }
}
