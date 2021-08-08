package lclang.methods

import lclang.*
import lclang.types.BaseType
import lclang.types.Type
import lclang.types.Types

open class VisitorMethod(private val methodContext: lclangParser.MethodContext): Method(
    run {
        val args = ArrayList<BaseType>()
        for (arg in methodContext.args().arg())
            args.add(Types.getType(arg.type()))

        return@run args
    },

    if(methodContext.type()!=null)
        Types.getType(methodContext.type())
    else Types.VOID
) {

    override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
        val lcContextVisitor = LCBaseVisitor(fileVisitor)

        val methodArgs = methodContext.args().arg()
        for(argNum in 0 until methodArgs.size){
            lcContextVisitor.variables[methodArgs[argNum].ID().text] = Value({
               this.args[argNum]
            }, { args[argNum] })
        }

        val value = lcContextVisitor.visitBlock(methodContext.block())
        val valueType = value?.type?.invoke()
        if(valueType!=null&&!returnType.isAccept(valueType)||
                valueType==null&&returnType!= Types.VOID)
            throw Exception("invalid type of return")

        return value?.get?.invoke()
    }
}