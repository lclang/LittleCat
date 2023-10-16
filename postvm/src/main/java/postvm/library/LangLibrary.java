package postvm.library;

import postvm.Library;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
import postvm.methods.MethodInstance;

public final class LangLibrary extends Library {
    public static final LangLibrary INSTANCE = new LangLibrary();

    private LangLibrary() {
        super("lang");

        classes.put("any", ObjectClassInstance.PROTOTYPE);
        classes.put("object", ObjectClassInstance.PROTOTYPE);
        classes.put("array", ArrayClassInstance.PROTOTYPE);
        classes.put("bool", BoolClassInstance.PROTOTYPE);
        classes.put("char", CharClassInstance.PROTOTYPE);

        classes.put("double", NumberClassInstance.PROTOTYPE);
        classes.put("int", NumberClassInstance.PROTOTYPE);
        classes.put("long", NumberClassInstance.PROTOTYPE);
        classes.put("number", NumberClassInstance.PROTOTYPE);

        classes.put("string", StringClassInstance.PROTOTYPE);
        classes.put("null", NullClassInstance.PROTOTYPE);
        classes.put("callable", MethodInstance.PROTOTYPE);
        classes.put("void", VoidClassInstance.PROTOTYPE);
    }
}
