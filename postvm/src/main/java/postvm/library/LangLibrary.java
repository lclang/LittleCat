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

        classes.put("any", PostVMClass.OBJECT_INSTANCE);
        classes.put("object", PostVMClass.OBJECT_INSTANCE);
        classes.put("array", ArrayClass.INSTANCE);
        classes.put("bool", BoolClass.INSTANCE);
        classes.put("char", CharClass.INSTANCE);
        classes.put("double", DoubleClass.INSTANCE);
        classes.put("int", IntClass.INSTANCE);
        classes.put("long", LongClass.INSTANCE);
        classes.put("number", NumberClass.INSTANCE);
        classes.put("string", StringClass.INSTANCE);
        classes.put("null", NullClass.INSTANCE);
        classes.put("callable", Method.INSTANCE);
        classes.put("void", VoidClass.INSTANCE);
    }
}
