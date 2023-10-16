package postvm.exceptions;

public class LCLangIOException extends LCLangRuntimeException {
    public LCLangIOException(String message, int caller) {
        super("IO Exception", message, caller);
    }
}
