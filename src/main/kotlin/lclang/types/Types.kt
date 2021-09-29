package lclang.types

import lclang.lclangParser

object Types {
    val VOID = NamedType("void", true)
    val ANY = NamedType("any", true)
    val INT = NamedType("int", true)
    val LONG = NamedType("long", true)
    val BOOL = NamedType("bool", true)
    val STRING = NamedType("string", true)
    val CHAR = NamedType("char", true)
    val ARRAY = NamedType("array", true)
    val DOUBLE = NamedType("double", true)
    val CALLABLE = NamedType("callable", true)
    val UNDEFINED = NamedType("undefined", true)

    fun getType(context: lclangParser.TypeContext): Type {
        val type = when{
            context.baseType()!=null -> getNamedType(context.baseType())
            context.methodType()!=null -> getCallType(context.methodType())
            else -> throw Exception("Future error")
        }

        type.nullable = context.nullable!=null
        return type
    }

    fun getNamedType(ctx: lclangParser.BaseTypeContext): NamedType {
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
            else -> NamedType(stringName)
        }
    }

    fun getCallType(ctx: lclangParser.MethodTypeContext): CallableType {
        val args = ArrayList<Type>()
        for(argType in ctx.type().dropLast(1))
            args.add(getType(argType))

        return CallableType(args, getType(ctx.returnType))
    }
}