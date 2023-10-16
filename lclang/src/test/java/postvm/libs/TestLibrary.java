package postvm.libs;

import postvm.Library;
import postvm.library.classes.ObjectClassInstance;
import postvm.classes.PostVMClassInstance;

public class TestLibrary extends Library {
    public static final TestLibrary INSTANCE = new TestLibrary();
    public static StringBuilder output = new StringBuilder();

    private TestLibrary() {
        super("test");
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "print": return voidMethod((caller, args) ->
                    output.append(args[0].toString(caller)), ObjectClassInstance.OBJECT_TYPE);
            case "println": return voidMethod((caller, args) ->
                    output.append(args[0].toString(caller)).append("\r\n"), ObjectClassInstance.OBJECT_TYPE);
        }

        return super.loadMethod(clazz, target);
    }
}
