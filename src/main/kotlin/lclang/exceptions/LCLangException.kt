package lclang.exceptions

open class LCLangException(exceptionName: String, message: String, line: Int, column: Int, path: String):
    Exception("$exceptionName: $message at line $line, column $column in $path:$line")