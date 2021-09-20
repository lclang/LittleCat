package lclang.libs

import lclang.LCFileVisitor

abstract class Library(
    libraryName: String
): LCFileVisitor(libraryName) {
    init {
        fileVisitor = this
    }
}