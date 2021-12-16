package postvm.exceptions;

import postvm.Caller;

public class LCLangClassNotFoundException extends LCLangRuntimeException {
    public LCLangClassNotFoundException(String clazz, Caller caller) {
        super("Uncaught Error", "Class "+clazz+" not found", caller);
    }
}
