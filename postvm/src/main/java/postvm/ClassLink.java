package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;

public class ClassLink extends Link {
    private final PostVMClass clazz;

    public ClassLink(PostVMClass clazz, State state) {
        super(state);
        this.clazz = clazz;
    }

    @Override
    public PostVMClass get(Caller caller) throws LCLangRuntimeException {
        return clazz;
    }
}
