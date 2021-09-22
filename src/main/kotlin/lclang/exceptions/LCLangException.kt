package lclang.exceptions

import lclang.Caller

open class LCLangException(exceptionName: String, message: String, caller: Caller):
    Exception("$exceptionName: $message at line ${caller.line}, column ${caller.column} in ${caller.file.path}:${caller.line}")