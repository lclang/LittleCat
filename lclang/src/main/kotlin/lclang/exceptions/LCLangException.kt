package lclang.exceptions

import lclang.Caller

open class LCLangException(exceptionName: String, message: String, caller: Caller):
    Exception("$exceptionName: $message\n"+caller.toList().reversed().joinToString("\n") {
        "\tat line ${it.line}, column ${it.column} in ${it.root.path}:${it.line}"
    })