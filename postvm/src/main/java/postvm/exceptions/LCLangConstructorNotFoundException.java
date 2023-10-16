package postvm.exceptions;

public class LCLangConstructorNotFoundException extends LCLangRuntimeException {
    public LCLangConstructorNotFoundException(int caller) {
        super("Uncaught Error", "Constructor not found", caller);
    }
}
