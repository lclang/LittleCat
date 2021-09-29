package lclang.methods

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.TypeErrorException
import lclang.lclangParser
import lclang.types.Type
import lclang.types.Types

open class VisitorMethod(
    val executor: LCBaseExecutor,
    returnType: Type,
    private val methodArgs: List<lclangParser.ArgContext>,
    private val execute: (LCBaseExecutor) -> Value): Method(
        executor.root,
        methodArgs.map {
            val argType = it.type()
            if (argType != null)
                Types.getType(argType)
            else Types.ANY
        }, returnType) {

    override fun call(caller: Caller, args: List<Value>): Any? {
        val lcContextVisitor = LCBaseExecutor(executor)

        for((argNum, argName) in methodArgs.withIndex()){
            lcContextVisitor.variables[argName.ID().text] = args[argNum]
        }

        val value = execute(lcContextVisitor)
        val valueType = value.type
        if(!returnType.isAccept(valueType))
            throw TypeErrorException("invalid type of return", caller)

        return value.get(caller)
    }
}