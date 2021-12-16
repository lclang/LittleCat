package postvm.libs;

import postvm.Library;
import postvm.library.classes.PostVMClass;

public class TestLibrary extends Library {
    public final StringBuilder output;

    public TestLibrary(StringBuilder output) {
        super("test");
        this.output = output;
        globals.put("print", voidMethod((caller, args) ->
                output.append(args.get(0).toString(caller)), PostVMClass.OBJECT_TYPE));
        globals.put("println", voidMethod((caller, args) ->
                output.append(args.get(0).toString(caller)).append("\r\n"), PostVMClass.OBJECT_TYPE));
    }
}
