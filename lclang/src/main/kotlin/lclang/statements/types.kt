package lclang.statements

import lclang.Caller
import lclang.LCRootExecutor
import lclang.exceptions.ClassNotFoundException
import lclang.types.CallableType
import lclang.types.NamedType
import lclang.types.Type
import lclang.types.Types

abstract class TypeStatement(val line: Int) {
    var nullable = false

    abstract fun toType(root: LCRootExecutor): Type
    fun getCaller(root: LCRootExecutor): Caller = Caller(root, line)

    companion object {
        val ANY = MagicTypeStatement(Types.ANY)
        val VOID = MagicTypeStatement(Types.VOID)
    }
}

class NamedTypeStatement(val name: String, line: Int): TypeStatement(line) {
    override fun toType(root: LCRootExecutor): NamedType = NamedType(root.classes[name]?:
                throw ClassNotFoundException(name, getCaller(root))).apply {
        nullable = this@NamedTypeStatement.nullable
    }
}

class MagicTypeStatement(val type: Type): TypeStatement(0) {
    override fun toType(root: LCRootExecutor): Type = type
}

class CallableTypeStatement(
    val args: Array<TypeStatement>,
    val returnType: TypeStatement, line: Int
): TypeStatement(line) {
    override fun toType(root: LCRootExecutor): CallableType = CallableType(args.map {
        it.toType(root)
    }, returnType.toType(root)).apply {
        nullable = this@CallableTypeStatement.nullable
    }
}