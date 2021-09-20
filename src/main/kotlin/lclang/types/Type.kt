package lclang.types

import lclang.lclangParser

class Type(
    val name: String,
    val primitive: Boolean = false
): BaseType(name){
    companion object {

        fun from(ctx: lclangParser.BaseTypeContext): Type {
            return when(val stringName: String = ctx.text){
                "void" -> Types.VOID
                "any" -> Types.ANY
                "int" -> Types.INT
                "long" -> Types.LONG
                "char" -> Types.CHAR
                "string" -> Types.STRING
                "array" -> Types.ARRAY
                "bool" -> Types.BOOL
                "double" -> Types.DOUBLE
                "callable" -> Types.CALLABLE
                else -> Type(stringName)
            }
        }
    }

    override fun isAcceptWithoutNullable(another: BaseType): Boolean {
        return super.isAcceptWithoutNullable(another) ||
                another is Type &&
                another.primitive && primitive &&
                another.name == name
    }
}