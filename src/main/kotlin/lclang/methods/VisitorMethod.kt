package lclang.methods

import lclang.LCBaseVisitor
import lclang.LCFileVisitor
import lclang.Value
import lclang.lclangParser
import lclang.types.BaseType
import lclang.types.Types

abstract class VisitorMethod(returnType: BaseType,
                         private val methodArgs: List<lclangParser.ArgContext>,
                         private val execute: (LCBaseVisitor) -> Value?): Method(
    run {
        val args = ArrayList<BaseType>()
        for (arg in methodArgs)
            args.add(Types.getType(arg.type()))

        return@run args
    }, returnType) {

    override fun call(fileVisitor: LCFileVisitor, args: List<Value>): Any? {
        val lcContextVisitor = LCBaseVisitor(fileVisitor)

        for((argNum, argName) in methodArgs.withIndex()){
            lcContextVisitor.variables[argName.ID().text] = args[argNum]
        }

        val value = execute(lcContextVisitor)
        val valueType = value?.type?.invoke()
        if(valueType!=null&&!returnType.isAccept(valueType)||
                valueType==null&&returnType!= Types.VOID)
            throw Exception("invalid type of return")

        return value?.get?.invoke()
    }
}