package lclang.methods

import lclang.LCContextVisitor
import lclang.Type
import lclang.Value
import lclang.lclangParser

class VisitorMethod(private val methodContext: lclangParser.MethodContext,
        private val parent: LCContextVisitor): Method(
    run {
        val args = ArrayList<Type>()
        for (arg in methodContext.args().arg())
            args.add(Type.from(arg.type()))

        return@run args
    },
    if(methodContext.type()!=null)
        Type.from(methodContext.type())
    else Type.VOID
) {
    override fun call(args: List<Value?>): Any? {
        val lcContextVisitor = LCContextVisitor(parent)

        val methodArgs = methodContext.args().arg()
        for(argNum in 0 until methodArgs.size){
            lcContextVisitor.variables[methodArgs[argNum].ID().text] = args[argNum]
        }

        return lcContextVisitor.visitBlock(methodContext.block())
    }
}