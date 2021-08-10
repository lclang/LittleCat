package lclang.methods

import lclang.LCFileVisitor
import lclang.Value
import lclang.types.BaseType

abstract class LibraryMethod(args: List<BaseType>, returnType: BaseType) : Method(args, returnType) {
    override fun call(fileVisitor: LCFileVisitor, args: List<Value>): Any? {
        return callMethod(fileVisitor, args.map { it.get() })
    }

    abstract fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any?
}