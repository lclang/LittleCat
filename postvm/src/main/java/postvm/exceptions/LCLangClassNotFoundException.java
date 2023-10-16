package postvm.exceptions;

public class LCLangClassNotFoundException extends LCLangRuntimeException {
    public LCLangClassNotFoundException(String clazz, int caller) {
        super("Uncaught Error", "Class "+clazz+" not found", caller);
    }
}
