package postvm.utils;

import postvm.exceptions.LCLangRuntimeException;

public interface Function<ARG, RET> {
    RET invoke(ARG arg) throws LCLangRuntimeException;
}
