package lclang.utils;

import lclang.exceptions.LCLangRuntimeException;

public interface VoidMethod2<ARG, ARG2> {
    void invoke(ARG arg, ARG2 arg2) throws LCLangRuntimeException;
}
