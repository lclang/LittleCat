package lclang.types

import lclang.LCRootExecutor
import lclang.asCaller
import lclang.exceptions.ClassNotFoundException
import lclang.lclangParser

object Types {
    val VOID = MagicType("void")
    val ANY = MagicType("any")
    val CALLABLE = MagicType("callable")
    val UNDEFINED = MagicType("undefined")

    val INT = MagicType("int")
    val LONG = MagicType("long")
    val BOOL = MagicType("bool")
    val STRING = MagicType("string")
    val CHAR = MagicType("char")
    val ARRAY = MagicType("array")
    val DOUBLE = MagicType("double")

    fun getType(root: LCRootExecutor, context: lclangParser.TypeContext): Type {
        val type = when{
            context.namedType()!=null -> when(context.text) {
                "any" -> ANY
                "void" -> VOID
                "callable" -> CALLABLE
                else -> getNamedType(root, context.namedType())
            }

            context.methodType()!=null -> getCallType(root, context.methodType())
            else -> throw Exception("Future error")
        }

        type.nullable = context.nullable!=null
        return type
    }

    private fun getNamedType(root: LCRootExecutor, ctx: lclangParser.NamedTypeContext): NamedType {
        return NamedType(root.classes[ctx.text] ?: throw ClassNotFoundException(ctx.text,
            ctx.asCaller(root)))
    }

    private fun getCallType(root: LCRootExecutor, ctx: lclangParser.MethodTypeContext): CallableType {
        val args = ArrayList<Type>()
        for(argType in ctx.type().dropLast(1))
            args.add(getType(root, argType))

        return CallableType(args.toTypedArray(), getType(root, ctx.returnType))
    }

    class MagicType(name: String): Type(name) {
        override fun isAcceptWithoutNullable(another: Type): Boolean {
            return another is NamedType &&
                    another.clazz.name == text
        }
    }
}