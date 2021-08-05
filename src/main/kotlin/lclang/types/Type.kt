package lclang.types

import lclang.lclangParser

class Type(
    val name: String,
    val primitive: Boolean = false
): BaseType(name){
    companion object {
        val VOID = Type("void", true)
        val ANY = Type("any", true)
        val INT = Type("int", true)
        val LONG = Type("long", true)
        val BOOL = Type("bool", true)
        val STRING = Type("string", true)
        val CHAR = Type("char", true)
        val ARRAY = Type("array", true)
        val DOUBLE = Type("double", true)
        val CALLABLE = Type("callable", true)

        fun from(ctx: lclangParser.BaseTypeContext): Type {
            return when(val stringName: String = ctx.text){
                "void" -> VOID
                "any" -> ANY
                "int" -> INT
                "long" -> LONG
                "char" -> CHAR
                "string" -> STRING
                "array" -> ARRAY
                "bool" -> BOOL
                "double" -> DOUBLE
                "callable" -> CALLABLE
                else -> Type(stringName)
            }
        }
    }

    override fun isAccept(another: BaseType): Boolean {
        if(this == ANY) return true
        if((another as Type).primitive&&primitive)
            return another.name == name

        return false
    }
}