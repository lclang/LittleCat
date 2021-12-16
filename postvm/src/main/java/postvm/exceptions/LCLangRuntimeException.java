package postvm.exceptions;

import postvm.Caller;

public class LCLangRuntimeException extends RuntimeException {
    public LCLangRuntimeException(String name, String message, Caller caller) {
        super(name+": "+message+"\n\t"+String.join("\n\t", caller.toStacktrace()));
    }
}
