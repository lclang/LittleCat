package lclang.utils;

import lclang.exceptions.LCLangException;

public interface Function0<RET> {
    RET invoke() throws LCLangException;
}
