package lclang.exceptions;

import lclang.Caller;

public class LCLangRuntimeException extends Exception {
    public LCLangRuntimeException(String name, String message, Caller caller) {
        super(name+": "+message+"\n\t"+String.join("\n\t", caller.toStacktrace()));
    }
}
