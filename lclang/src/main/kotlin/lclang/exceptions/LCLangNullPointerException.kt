package lclang.exceptions

import lclang.Caller
import lclang.statements.Statement

class LCLangNullPointerException(expression: Statement, caller: Caller):
    LCLangException("Uncaught Error", "Value ${expression} is null", caller)
