package lclang.methods

import lclang.*

class ClassMethod(val clazz: LCClass, private val methodContext: lclangParser.MethodContext):
    VisitorMethod(methodContext) {
    override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
        val lcContextVisitor = LCBaseVisitor(fileVisitor)
        lcContextVisitor.variables["this"] = Value({ Type(clazz.name) }, { clazz })

        val methodArgs = methodContext.args().arg()
        for(argNum in 0 until methodArgs.size){
            lcContextVisitor.variables[methodArgs[argNum].ID().text] = Value({
                this.args[argNum]
            }, { args[argNum] })
        }

        val value = lcContextVisitor.visitBlock(methodContext.block())
        val valueType = value?.type?.invoke()
        if(valueType!=null&&!returnType.isAccept(valueType)||
            valueType==null&&returnType!=Type.VOID)
            throw Exception("invalid type of return")

        return value?.get?.invoke()
    }
}