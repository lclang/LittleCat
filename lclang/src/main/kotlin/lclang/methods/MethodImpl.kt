package lclang.methods

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.LCClass
import lclang.Value
import lclang.exceptions.TypeErrorException
import lclang.statements.Statement
import lclang.types.Type

class MethodImpl(
    private val e: LCBaseExecutor,
    private val argsMap: Map<String, Type>,
    returnType: Type,
    val statement: Statement): Method(e.root, argsMap.values.toTypedArray(), returnType) {
    override fun call(caller: Caller, args: List<Value>): LCClass? {
        val executor = LCBaseExecutor(e)

        for((argNum, argName) in argsMap.keys.withIndex()){
            executor.variables[argName] = args[argNum]
        }

        val value = statement.visit(caller, executor)
        val valueType = value.type
        if(!returnType.isAccept(valueType))
            throw TypeErrorException("invalid type of return (excepted $returnType, but returned $valueType)", caller)

        return value.get(caller)
    }
}