package postvm.utils;

import postvm.exceptions.LCLangRuntimeException;

public interface Function3<ARG, ARG2, ARG3, RET> {
    RET invoke(ARG arg, ARG2 arg2, ARG3 arg3) throws LCLangRuntimeException;
}
