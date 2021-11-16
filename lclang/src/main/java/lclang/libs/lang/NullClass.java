package lclang.libs.lang;

import lclang.LCClass;

public class NullClass extends LCClass {
    public static final NullClass NULL = new NullClass();
    private NullClass() {
        super("null");
    }
}
