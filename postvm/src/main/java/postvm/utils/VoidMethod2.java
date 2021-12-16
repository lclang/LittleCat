package postvm.utils;

import postvm.exceptions.LCLangRuntimeException;

public interface VoidMethod2<ARG, ARG2> {
    void invoke(ARG arg, ARG2 arg2) throws LCLangRuntimeException;
}
