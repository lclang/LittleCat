package lclang.exceptions;

import lclang.Caller;

public class LCLangException extends Exception {
    public LCLangException(String name, String message, Caller caller) {
        super(name+": "+message+"\n\t"+String.join("\n\t", caller.toStacktrace()));
    }
}
