package lclang.utils;

import lclang.exceptions.LCLangRuntimeException;

public interface VoidMethod<ARG> {
    void invoke(ARG arg) throws LCLangRuntimeException;
}
