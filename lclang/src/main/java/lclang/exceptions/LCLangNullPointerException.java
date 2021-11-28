package lclang.exceptions;

import lclang.Caller;

public class LCLangNullPointerException extends LCLangRuntimeException {
    public LCLangNullPointerException(Caller caller) {
        super("Uncaught Error", "Value is null", caller);
    }
}
