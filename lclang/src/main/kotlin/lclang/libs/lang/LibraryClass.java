package lclang.libs.lang;

import lclang.LCClass;
import lclang.types.Types;

public class LibraryClass extends LCClass {
    public static String name;

    public LibraryClass() {
        super(name);
    }

    public static Types.MagicType getType() {
        return new Types.MagicType(name);
    }
}
