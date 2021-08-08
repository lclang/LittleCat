package lclang.types

abstract class BaseType(val text: String) {

    abstract fun isAccept(another: BaseType): Boolean

    override fun toString(): String {
        return text
    }
}