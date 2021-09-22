package lclang.exceptions

import lclang.Caller

class VariableNotFoundException(variable: String, caller: Caller):
    LCLangException("Uncaught Error", "Variable $variable not found", caller)