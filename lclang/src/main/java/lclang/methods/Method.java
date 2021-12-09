package lclang.methods;

import lclang.Caller;
import lclang.LCRootExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;
import lclang.libs.lang.classes.NullClass;
import lclang.types.CallableType;
import lclang.types.Type;

import java.util.List;

public class Method extends LCClass {
    public static final String name = "callable";
    public static final Method instance = new Method();
    public static final Type type = instance.classType;

    public LCRootExecutor root;
    public List<Type> args;
    public Type returnType;

    private Method() {
        super(name);
    }

    public Method(LCRootExecutor root, List<Type> args, Type returnType) {
        super(name);
        this.root = root;
        this.args = args;
        this.returnType = returnType;
        this.classType = new CallableType(args, returnType);
    }

    public LCClass call(Caller caller, List<LCClass> args) throws LCLangRuntimeException {
        return NullClass.instance;
    }

    @Override
    public Link createLink() {
        return new Link(this, Link.State.NOTHING);
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return classType.toString();
    }
}
