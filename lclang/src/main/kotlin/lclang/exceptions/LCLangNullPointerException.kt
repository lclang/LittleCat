package lclang.exceptions

import lclang.Caller

class LCLangNullPointerException(caller: Caller):
    LCLangException("Uncaught Error", "Value is null", caller)
