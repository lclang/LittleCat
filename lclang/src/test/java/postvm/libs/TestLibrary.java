package postvm.libs;

import postvm.Library;
import postvm.library.classes.PostVMClass;

public class TestLibrary extends Library {
    public final StringBuilder output;

    public TestLibrary(StringBuilder output) {
        super("test");
        this.output = output;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "print": return voidMethod((caller, args) ->
                    output.append(args.get(0).toString(caller)), PostVMClass.OBJECT_TYPE);
            case "println": return voidMethod((caller, args) ->
                    output.append(args.get(0).toString(caller)).append("\r\n"), PostVMClass.OBJECT_TYPE);
        }

        return super.loadGlobal(target);
    }
}
