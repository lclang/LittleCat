package lclang.libs.lang;

import lclang.LCClass;

public class BoolClass extends LCClass {
    public static final BoolClass TRUE = new BoolClass(true);
    public static final BoolClass FALSE = new BoolClass();
    public BoolClass() {
        super("bool");
    }

    public boolean bool;
    public BoolClass(boolean bool) {
        this();
        this.bool = bool;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof BoolClass)
            return ((BoolClass) other).bool == bool;

        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(bool);
    }
}
