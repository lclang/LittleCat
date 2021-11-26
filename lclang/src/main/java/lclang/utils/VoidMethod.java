package lclang.utils;

import lclang.exceptions.LCLangException;

public interface VoidMethod<ARG> {
    void invoke(ARG arg) throws LCLangException;
}
