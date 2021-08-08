package lclang.types

import lclang.lclangParser

object Types {
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
    val UNDEFINED = Type("undefined", true)

    fun getType(type: lclangParser.TypeContext): BaseType {
        return when{
            type.baseType()!=null -> Type.from(type.baseType())
            type.methodType()!=null -> CallableType.from(type.methodType())
            else -> throw Exception("Future error")
        }
    }
}