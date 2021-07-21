package lclang.exceptions

class VariableNotFoundException(variable: String, line: Int, column: Int, path: String):
    LCLangException(VariableNotFoundException::class.simpleName!!,
        "Variable $variable not found", line, column, path)