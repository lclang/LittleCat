package lclang.libs.lang;

import lclang.libs.Library;
import lclang.libs.lang.classes.*;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.LongClass;
import lclang.libs.lang.classes.numbers.NumberClass;
import lclang.methods.Method;

public class LangLibrary extends Library {
    public LangLibrary() {
        super("lang");
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
