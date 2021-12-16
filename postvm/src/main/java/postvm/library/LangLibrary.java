package postvm.library;

import postvm.Library;
import postvm.library.classes.*;
import postvm.library.classes.numbers.DoubleClass;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;

public class LangLibrary extends Library {
    public LangLibrary() {
        super("lang");
        classes.put("any", PostVMClass.OBJECT_INSTANCE);
        classes.put("object", PostVMClass.OBJECT_INSTANCE);
        classes.put("array", ArrayClass.instance);
        classes.put("bool", BoolClass.instance);
        classes.put("char", CharClass.instance);
        classes.put("double", DoubleClass.INSTANCE);
        classes.put("int", IntClass.INSTANCE);
        classes.put("long", LongClass.INSTANCE);
        classes.put("number", NumberClass.INSTANCE);
        classes.put("string", StringClass.instance);
        classes.put("null", NullClass.instance);
        classes.put("callable", Method.instance);
    }
}
