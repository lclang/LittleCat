package lclang.types

abstract class Type(val text: String) {
    var nullable = false

    fun isAccept(another: Type): Boolean {
        return isAcceptWithoutNullable(another) && (nullable || !another.nullable)
    }

    open fun isAcceptWithoutNullable(another: Type):
            Boolean = Types.ANY==this|| Types.UNDEFINED==another

    fun nullable(): Type {
        nullable = true
        return this
    }

    override fun toString(): String {
        return (if(nullable) "?" else "") + text
    }
}