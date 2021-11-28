package lclang.exceptions;

import lclang.Caller;

public class LCLangVariableNotFoundException extends LCLangRuntimeException {
    public LCLangVariableNotFoundException(String clazz, Caller caller) {
        super("Uncaught Error", "Variable "+clazz+" not found", caller);
    }
}
