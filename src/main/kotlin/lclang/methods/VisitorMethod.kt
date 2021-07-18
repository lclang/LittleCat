package lclang.methods

import lclang.Type
import lclang.lclangParser

class VisitorMethod(methodContext: lclangParser.MethodContext): Method(
    run {
        val args = ArrayList<Type>()
        for (arg in methodContext.args().arg())
            args.add(Type.from(arg.type()))

        return@run args
    },
    Type.from(methodContext.type())
) {
    override fun call(args: List<Any?>): Any? {

        return null
    }
}