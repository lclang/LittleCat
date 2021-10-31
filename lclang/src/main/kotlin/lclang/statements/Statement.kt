package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value

abstract class Statement(val line: Int, val column: Int) {
    abstract fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value

    fun getCaller(caller: Caller) = Caller(caller.root, line, column, caller)
}