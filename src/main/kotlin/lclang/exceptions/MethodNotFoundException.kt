package lclang.exceptions

class MethodNotFoundException(method: String, line: Int, column: Int) : Exception("Method $method not found at line $line, column $column") {}