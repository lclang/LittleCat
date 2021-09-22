package lclang.exceptions

import lclang.Caller

class MethodNotFoundException(method: String, caller: Caller):
    LCLangException("Uncaught Error", "Method $method not found", caller)
