package postvm.exceptions;

import postvm.Caller;

public class LCLangNullPointerException extends LCLangRuntimeException {
    public LCLangNullPointerException(Caller caller) {
        super("Uncaught Error", "Value is null", caller);
    }
}
