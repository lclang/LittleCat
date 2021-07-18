package lclang.exceptions

class MethodNotFoundException(variable: String, line: Int, column: Int) : Exception("Method $variable not found at line $line, column $column") {}