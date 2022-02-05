package postvm.library;

import postvm.Library;
import postvm.library.classes.*;
import postvm.library.classes.numbers.DoubleClass;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;

public final class LangLibrary extends Library {
    public LangLibrary() {
        super("lang");

        classes.put("any", PostVMClass.PROTOTYPE);
        classes.put("object", PostVMClass.PROTOTYPE);
        classes.put("array", ArrayClass.PROTOTYPE);
        classes.put("bool", BoolClass.PROTOTYPE);
        classes.put("char", CharClass.PROTOTYPE);
        classes.put("double", DoubleClass.PROTOTYPE);
        classes.put("int", IntClass.PROTOTYPE);
        classes.put("long", LongClass.PROTOTYPE);
        classes.put("number", NumberClass.PROTOTYPE);
        classes.put("string", StringClass.PROTOTYPE);
        classes.put("null", NullClass.PROTOTYPE);
        classes.put("callable", Method.PROTOTYPE);
        classes.put("void", VoidClass.PROTOTYPE);
    }
}
