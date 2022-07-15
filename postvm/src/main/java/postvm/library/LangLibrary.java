package postvm.library;

import postvm.Library;
import postvm.library.classes.*;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;

public final class LangLibrary extends Library {
    public static final LangLibrary INSTANCE = new LangLibrary();

    private LangLibrary() {
        super("lang");

        classes.put("any", ObjectClass.PROTOTYPE);
        classes.put("object", ObjectClass.PROTOTYPE);
        classes.put("array", ArrayClass.PROTOTYPE);
        classes.put("bool", BoolClass.PROTOTYPE);
        classes.put("char", CharClass.PROTOTYPE);

        classes.put("double", NumberClass.PROTOTYPE);
        classes.put("int", NumberClass.PROTOTYPE);
        classes.put("long", NumberClass.PROTOTYPE);
        classes.put("number", NumberClass.PROTOTYPE);

        classes.put("string", StringClass.PROTOTYPE);
        classes.put("null", NullClass.PROTOTYPE);
        classes.put("callable", Method.PROTOTYPE);
        classes.put("void", VoidClass.PROTOTYPE);
    }
}
