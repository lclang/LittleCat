package postvm.exceptions;

public class LCLangVariableNotFoundException extends LCLangRuntimeException {
    public LCLangVariableNotFoundException(String clazz, int caller) {
        super("Uncaught Error", "Variable "+clazz+" not found", caller);
    }
}
