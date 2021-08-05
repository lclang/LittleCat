package lclang.types

import lclang.lclangParser

object Types {
    fun getType(type: lclangParser.TypeContext): Type {
        return when{
            type.baseType()!=null -> Type.from(type.baseType())
            else -> throw Exception("Future error")
        }
    }
}