package lclang.methods

import lclang.LCContextVisitor
import lclang.Type
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
    override fun call(args: List<Any?>): Any? {
        val lcContextVisitor = LCContextVisitor(parent)
        for(arg in methodContext.args().arg()){
            lcContextVisitor.variables[arg.ID().text] = args
        }

        return lcContextVisitor.visitBlock(methodContext.block())
    }
}