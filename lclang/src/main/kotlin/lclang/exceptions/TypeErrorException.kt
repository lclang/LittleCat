package lclang.exceptions

import lclang.Caller

class TypeErrorException(message: String, caller: Caller):
    LCLangException("Type Error", message, caller)