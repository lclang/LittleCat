package lclang.utils;

import lclang.exceptions.LCLangException;

public interface Function<ARG, RET> {
    RET invoke(ARG arg) throws LCLangException;
}
