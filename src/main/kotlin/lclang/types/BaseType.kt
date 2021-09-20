package lclang.types

abstract class BaseType(val text: String) {
    var nullable = false

    fun isAccept(another: BaseType): Boolean {
        return isAcceptWithoutNullable(another) && (nullable || !another.nullable)
    }

    open fun isAcceptWithoutNullable(another: BaseType):
            Boolean = Types.ANY==this|| Types.UNDEFINED==another

    fun nullable(): BaseType {
        nullable = true
        return this
    }

    override fun toString(): String {
        return (if(nullable) "?" else "") + text
    }
}