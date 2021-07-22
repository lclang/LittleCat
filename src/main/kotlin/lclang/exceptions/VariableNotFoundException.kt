package lclang.exceptions

class VariableNotFoundException(variable: String, line: Int, column: Int, path: String):
    LCLangException("Uncaught Error", "Variable $variable not found", line, column, path)