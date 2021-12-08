package lclang.exceptions;

import lclang.Caller;

public class LCLangConstructorNotFoundException extends LCLangRuntimeException {
    public LCLangConstructorNotFoundException(Caller caller) {
        super("Uncaught Error", "Constructor not found", caller);
    }
}
