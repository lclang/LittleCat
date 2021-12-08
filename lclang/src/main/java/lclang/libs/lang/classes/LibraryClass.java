package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.exceptions.LCLangRuntimeException;
import lclang.methods.Method;
import lclang.types.Type;
import lclang.utils.Function2;
import lclang.utils.VoidMethod2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class LibraryClass extends LCClass {
    public LibraryClass(String name) {
        super(name);
    }

    public Method voidMethod(VoidMethod2<Caller, List<LCClass>> body, Type... args) {
        List<Type> arguments = Arrays.asList(args);

        return new Method(this, arguments, VoidClass.type) {
            @Override
            public LCClass call(Caller caller, List<LCClass> args) throws LCLangRuntimeException {
                body.invoke(
                        caller,
                        args
                );

                return VoidClass.instance;
            }
        };
    }

    public Method method(Function2<Caller, List<LCClass>, LCClass> body, Type... args) {
        Type returnType = args[args.length-1];
        List<Type> arguments = new ArrayList<>(Arrays.asList(args));
        arguments.remove(args.length-1);

        return new Method(this, arguments, returnType) {
            @Override
            public LCClass call(Caller caller, List<LCClass> args) throws LCLangRuntimeException {
                return body.invoke(
                        caller,
                        args
                );
            }
        };
    }
}
