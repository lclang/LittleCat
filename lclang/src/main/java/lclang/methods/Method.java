package lclang.methods;

import lclang.Caller;
import lclang.LCClass;
import lclang.LCRootExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.types.CallableType;
import lclang.types.Type;

import java.util.List;

public abstract class Method extends LCClass{
    public final LCRootExecutor root;
    public final Type[] args;
    public final Type returnType;
    private final Type type;

    public Method(LCRootExecutor root, Type[] args, Type returnType) {
        super("callable");
        this.root = root;
        this.args = args;
        this.returnType = returnType;
        this.type = new CallableType(args, returnType);
    }

    public abstract Value call(Caller caller, List<Value> args) throws LCLangException;

    @Override
    public Value asValue() {
        return new Value(type, this, Value.State.NOTHING);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}