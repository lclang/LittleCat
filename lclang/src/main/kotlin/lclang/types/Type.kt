package lclang.types

abstract class Type(val text: String): Cloneable {
    var nullable = false

    fun isAccept(another: Type): Boolean {
        if(Types.ANY==this || Types.UNDEFINED==another || another is Types.MagicType
            && another.text == text) return true
        return isAcceptWithoutNullable(another) && (nullable || !another.nullable)
    }

    open fun isAcceptWithoutNullable(another: Type): Boolean = false

    fun nullable(): Type {
        val newType = clone()
        newType.nullable = true
        return newType
    }

    fun notNullable(): Type {
        val newType = clone()
        newType.nullable = false
        return newType
    }

    override fun toString(): String {
        return (if(nullable) "?" else "") + text
    }

    public override fun clone(): Type {
        return super.clone() as Type
    }
}