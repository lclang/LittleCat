package postvm.utils;

import postvm.exceptions.LCLangRuntimeException;

public interface Function0<RET> {
    RET invoke() throws LCLangRuntimeException;
}
