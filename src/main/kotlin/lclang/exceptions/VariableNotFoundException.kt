package lclang.exceptions

class VariableNotFoundException(variable: String) : Exception("Variable $variable not found") {}