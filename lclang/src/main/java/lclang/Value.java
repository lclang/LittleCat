package lclang;

import lclang.exceptions.LCLangException;
import lclang.types.Type;
import lclang.types.Types;
import lclang.utils.Function;
import lclang.utils.Method2;

public class Value {
    public final Type type;
    public final Function<Caller, LCClass> get;
    public Method2<Caller, Value> set;
    public State state;
    public static Value VOID = new Value(Types.VOID, (LCClass) null, State.NOTHING);

    public Value(
            Type type,
            Function<Caller, LCClass> get,
            Method2<Caller, Value> set,
            State state
    ) {
        this.type = type;
        this.get = get;
        this.set = set;
        this.state = state;
    }

    public Value(
            Type type,
            Function<Caller, LCClass> get,
            State state
    ) {
        this(type, get, (caller, value) -> {
            throw new LCLangException(
                    "Invalid operation",
                    "Value is not settable",
                    caller);
        }, state);
    }

    public Value(
            Type type,
            Function<Caller, LCClass> get
    ) {
        this(type, get, (caller, value) -> {
            throw new LCLangException(
                    "Invalid operation",
                    "Value is not settable",
                    caller);
        }, State.NOTHING);
    }

    public Value(
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
