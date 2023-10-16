package postvm.exceptions;

public class LCLangNullPointerException extends LCLangRuntimeException {
    public LCLangNullPointerException(int caller) {
        super("Uncaught Error", "Value is null", caller);
    }
}
