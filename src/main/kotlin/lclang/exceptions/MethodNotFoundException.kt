package lclang.exceptions

class MethodNotFoundException(method: String, line: Int, column: Int, path: String):
    LCLangException("Uncaught Error", "Method $method not found", line, column, path)
