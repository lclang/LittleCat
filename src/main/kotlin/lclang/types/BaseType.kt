package lclang.types

abstract class BaseType(val text: String) {
    var nullable = false

    open fun isAccept(another: BaseType): Boolean {
        return Types.ANY==this||
                Types.UNDEFINED==another && nullable
    }

    fun nullable(): BaseType {
        nullable = true
        return this
    }

    override fun toString(): String {
        return (if(nullable) "?" else "") + text
    }
}