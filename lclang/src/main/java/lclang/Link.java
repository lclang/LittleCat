package lclang;

import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;
import lclang.utils.Function;
import lclang.utils.VoidMethod2;

public class Link {
    public final Function<Caller, LCClass> get;
    public VoidMethod2<Caller, LCClass> set;
    public State state;

    public Link(
            Function<Caller, LCClass> get,
            VoidMethod2<Caller, LCClass> set,
            State state
    ) {
        this.get = get;
        this.set = set;
        this.state = state;
    }

    public Link(
            Function<Caller, LCClass> get,
            State state
    ) {
        this(get, (caller, value) -> {
            throw new LCLangRuntimeException(
                    "Invalid operation",
                    "Value is not settable",
                    caller);
        }, state);
    }

    public Link(
            LCClass value,
            State state
    ) {
        this(caller -> value, state);
    }

    public enum State {
        RETURN,
        STOP,
        NOTHING
    }
}
