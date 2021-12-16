package postvm.exceptions;

import postvm.Caller;

public class LCLangIOException extends LCLangRuntimeException {
    public LCLangIOException(String message, Caller caller) {
        super("IO Exception", message, caller);
    }
}
