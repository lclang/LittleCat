package lclang.methods

import lclang.Caller
import lclang.LCBaseVisitor
import lclang.Value
import lclang.lclangParser
import lclang.types.Type
import lclang.types.Types

abstract class VisitorMethod(returnType: Type,
                             private val methodArgs: List<lclangParser.ArgContext>,
                             private val execute: (LCBaseVisitor) -> Value): Method(
    run {
        val args = ArrayList<Type>()
        for (arg in methodArgs)
            args.add(if(arg.type()!=null) Types.getType(arg.type()) else Types.ANY)

        return@run args
    }, returnType) {

    override fun call(caller: Caller, args: List<Value>): Any? {
        val lcContextVisitor = LCBaseVisitor(caller.file)

        for((argNum, argName) in methodArgs.withIndex()){
            lcContextVisitor.variables[argName.ID().text] = args[argNum]
        }

        val value = execute(lcContextVisitor)
        val valueType = value.type
        if(!returnType.isAccept(valueType))
            throw Exception("invalid type of return")

        return value.get(caller)
    }
}