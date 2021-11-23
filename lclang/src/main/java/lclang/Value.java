package lclang;

import lclang.exceptions.LCLangException;
import lclang.libs.lang.NullClass;
import lclang.types.Type;
import lclang.types.Types;
import lclang.utils.Function;
import lclang.utils.Method2;
import org.jetbrains.annotations.NotNull;

public class Value {
    public final Type type;
    public final Function<Caller, LCClass> get;
    public Method2<Caller, Value> set;
    public State state;
    public static Value VOID = new Value(Types.VOID, State.NOTHING);

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
            State state
    ) {
        this(type, caller -> NullClass.NULL, state);
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
            @NotNull LCClass value,
            State state
    ) {
        this(type, caller -> value, state);
    }

    public Value recreate(Caller caller) throws LCLangException {
        return new Value(type, get.invoke(caller), State.NOTHING);
    }

    public enum State {
        RETURN,
        STOP,
        NOTHING
    }
}
