package lclang

class Caller(
    val file: LCFileVisitor,
    val line: Int,
    val column: Int
)