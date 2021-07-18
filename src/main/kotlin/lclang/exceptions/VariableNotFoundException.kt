package lclang.exceptions

class VariableNotFoundException(variable: String, line: Int, column: Int, path: String):
    Exception("Variable $variable not found at line $line, column $column in $path:$line")