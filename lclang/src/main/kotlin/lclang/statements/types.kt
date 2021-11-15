package lclang.statements

import lclang.Caller
import lclang.exceptions.ClassNotFoundException
import lclang.types.CallableType
import lclang.types.NamedType
import lclang.types.Type
import lclang.types.Types

interface TypeStatement {
    fun toType(caller: Caller): Type
}

class NamedTypeStatement(val name: String): TypeStatement {
    override fun toType(caller: Caller): Type =
        when(name) {
            "any" -> Types.ANY
            "void" -> Types.VOID
            "callable" -> Types.CALLABLE
            else -> NamedType(caller.root.classes[name]?: throw ClassNotFoundException(name, caller))
        }
}

class CallableTypeStatement(
    val args: Array<TypeStatement>,
    val returnType: TypeStatement
): TypeStatement {
    override fun toType(caller: Caller): CallableType = CallableType(args.map {
        it.toType(caller)
    }.toTypedArray(), returnType.toType(caller))
}