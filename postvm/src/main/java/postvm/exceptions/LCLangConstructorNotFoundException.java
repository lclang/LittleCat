package postvm.exceptions;

import postvm.Caller;

public class LCLangConstructorNotFoundException extends LCLangRuntimeException {
    public LCLangConstructorNotFoundException(Caller caller) {
        super("Uncaught Error", "Constructor not found", caller);
    }
}
