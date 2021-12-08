package lclang;

import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;
import lclang.types.Type;
import lclang.utils.Function;
import lclang.utils.VoidMethod2;

public class Link {
    public final Type type;
    public final Function<Caller, LCClass> get;
    public VoidMethod2<Caller, LCClass> set;
    public State state;

    public Link(
            Type type,
            Function<Caller, LCClass> get,
            VoidMethod2<Caller, LCClass> set,
            State state
    ) {
        this.type = type;
        this.get = get;
        this.set = set;
        this.state = state;
    }

    public Link(
            Type type,
            Function<Caller, LCClass> get,
            State state
    ) {
        this(type, get, (caller, value) -> {
            throw new LCLangRuntimeException(
                    "Invalid operation",
                    "Value is not settable",
                    caller);
        }, state);
    }

    public Link(
            Type type,
            LCClass value,
            State state
    ) {
        this(type, caller -> value, state);
    }

    public enum State {
        RETURN,
        STOP,
        NOTHING
    }
}
