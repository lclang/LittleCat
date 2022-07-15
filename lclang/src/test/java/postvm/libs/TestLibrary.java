package postvm.libs;

import postvm.Library;
import postvm.library.classes.ObjectClass;
import postvm.library.classes.PostVMClass;

public class TestLibrary extends Library {
    public static final TestLibrary INSTANCE = new TestLibrary();
    public static StringBuilder output = new StringBuilder();

    private TestLibrary() {
        super("test");
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "print": return voidMethod((caller, args) ->
                    output.append(args[0].toString(caller)), ObjectClass.OBJECT_TYPE);
            case "println": return voidMethod((caller, args) ->
                    output.append(args[0].toString(caller)).append("\r\n"), ObjectClass.OBJECT_TYPE);
        }

        return super.loadGlobal(clazz, target);
    }
}
