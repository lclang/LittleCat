package lclang.utils;

import lclang.exceptions.LCLangException;

public interface Method2<ARG, ARG2> {
    void invoke(ARG arg, ARG2 arg2) throws LCLangException;
}
