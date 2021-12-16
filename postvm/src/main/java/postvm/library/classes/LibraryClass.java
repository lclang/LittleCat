package postvm.library.classes;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.Method;
import postvm.types.Type;
import postvm.utils.Function2;
import postvm.utils.VoidMethod2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class LibraryClass extends PostVMClass {
    public LibraryClass(String name) {
        super(name);
    }

    public Method voidMethod(VoidMethod2<Caller, List<PostVMClass>> body, Type... args) {
        List<Type> arguments = Arrays.asList(args);

        return new Method(arguments, VoidClass.type) {
            @Override
            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
                body.invoke(
                        caller,
                        args
                );

                return VoidClass.instance;
            }
        };
    }

    public Method method(Function2<Caller, List<PostVMClass>, PostVMClass> body, Type... args) {
        Type returnType = args[args.length-1];
        List<Type> arguments = new ArrayList<>(Arrays.asList(args));
        arguments.remove(args.length-1);

        return new Method(arguments, returnType) {
            @Override
            public PostVMClass call(Caller caller, List<PostVMClass> args) throws LCLangRuntimeException {
                return body.invoke(
                        caller,
                        args
                );
            }
        };
    }
}
