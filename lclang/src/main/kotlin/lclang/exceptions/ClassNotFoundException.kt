package lclang.exceptions

import lclang.Caller

class ClassNotFoundException(clazz: String, caller: Caller):
    LCLangException("Uncaught Error", "Class $clazz not found", caller)
