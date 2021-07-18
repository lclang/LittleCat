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
        for(argNum in 0 until methodContext.args().arg().size){
            lcContextVisitor.variables[methodContext.args().arg(argNum).ID().text] = args[argNum]
        }

        return lcContextVisitor.visitBlock(methodContext.block())
    }
}