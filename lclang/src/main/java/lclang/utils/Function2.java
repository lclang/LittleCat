package lclang.utils;

import lclang.exceptions.LCLangRuntimeException;

public interface Function2<ARG, ARG2, RET> {
    RET invoke(ARG arg, ARG2 arg2) throws LCLangRuntimeException;
}
