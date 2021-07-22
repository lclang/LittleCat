package lclang.exceptions

class TypeErrorException(message: String, line: Int, column: Int, path: String):
    LCLangException("Type Error", message, line, column, path)