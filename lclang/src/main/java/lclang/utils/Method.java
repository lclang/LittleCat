package lclang.utils;

import lclang.exceptions.LCLangException;

public interface Method<ARG> {
    void invoke(ARG arg) throws LCLangException;
}
