package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;

public abstract class Link {
    public State state;

    public Link(State state) {
        this.state = state;
    }

    public abstract PostVMClass get(Caller caller) throws LCLangRuntimeException;
    public void set(Caller caller, PostVMClass value) throws LCLangRuntimeException{
        throw new LCLangRuntimeException(
                "Invalid operation",
                "Value is not settable",
                caller);
    }

    public enum State {
        RETURN,
        STOP,
        NOTHING
    }
}
