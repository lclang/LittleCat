package lclang.utils;

import lclang.exceptions.LCLangRuntimeException;

public interface Function0<RET> {
    RET invoke() throws LCLangRuntimeException;
}
