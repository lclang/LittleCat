package postvm.utils;

import postvm.exceptions.LCLangRuntimeException;

public interface VoidMethod3<ARG, ARG2, ARG3> {
    void invoke(ARG arg, ARG2 arg2, ARG3 arg3) throws LCLangRuntimeException;
}
