package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.ClassNotFoundException

class GetClassConstructorExpression(
    val name: String,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val clazz = visitor.root.classes[name]
        if(clazz!=null)
            return clazz.constructor!!.asValue()

        throw ClassNotFoundException(name, caller)
    }
}