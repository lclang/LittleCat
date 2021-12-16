package postvm.utils;

import postvm.exceptions.LCLangRuntimeException;

public interface VoidMethod<ARG> {
    void invoke(ARG arg) throws LCLangRuntimeException;
}
