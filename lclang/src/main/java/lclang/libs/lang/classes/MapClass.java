package lclang.libs.lang.classes;

import lclang.types.Type;

public class MapClass extends LibraryClass {
    public static final String NAME = "map";
    public static final MapClass INSTANCE = new MapClass();
    public static final Type TYPE = INSTANCE.classType;

    private MapClass() {
        super(NAME);
    }
}
