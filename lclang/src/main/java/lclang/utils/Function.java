package lclang.utils;

import lclang.exceptions.LCLangRuntimeException;

public interface Function<ARG, RET> {
    RET invoke(ARG arg) throws LCLangRuntimeException;
}
