package lclang.libs.lang;

public class BoolClass extends LibraryClass {
    public static String name = "bool";
    public static final BoolClass TRUE = new BoolClass(true);
    public static final BoolClass FALSE = new BoolClass(false);

    public boolean bool;
    public BoolClass() {}
    public BoolClass(boolean bool) {
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
