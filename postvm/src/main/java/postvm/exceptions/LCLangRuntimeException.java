package postvm.exceptions;

import postvm.Caller;

import java.util.ArrayList;

public class LCLangRuntimeException extends RuntimeException {
    public LCLangRuntimeException(String name, String message, int caller) {
        super(name+": "+message+"\n\t"+String.join("\n\t",
                caller==0 ? new ArrayList<>():
                Caller.instances.get(caller).toStacktrace()));
    }
}
