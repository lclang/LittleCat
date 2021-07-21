package lclang.exceptions

class MethodNotFoundException(method: String, line: Int, column: Int, path: String):
    LCLangException(MethodNotFoundException::class.simpleName!!,
        "Method $method not found", line, column, path)
