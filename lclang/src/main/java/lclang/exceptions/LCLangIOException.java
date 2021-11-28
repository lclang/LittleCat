package lclang.exceptions;

import lclang.Caller;

public class LCLangIOException extends LCLangRuntimeException {
    public LCLangIOException(String message, Caller caller) {
        super("IO Exception", message, caller);
    }
}
