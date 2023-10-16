package postvm.exceptions;

import postvm.Caller;

public class LCLangTypeErrorException extends LCLangRuntimeException {
    public LCLangTypeErrorException(String message, int caller) {
        super("Type Error", message, caller);
    }
}
