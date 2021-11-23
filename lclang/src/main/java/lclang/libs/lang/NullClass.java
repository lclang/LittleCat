package lclang.libs.lang;

public class NullClass extends LibraryClass {
    public static final NullClass NULL = new NullClass();
    public static String name = "null";

    @Override
    public String toString() {
        return "null";
    }
}
