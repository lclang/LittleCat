package lclang

import lclang.exceptions.MethodNotFoundException
import lclang.exceptions.VariableNotFoundException
import lclang.methods.VisitorMethod

open class LCContextVisitor(
    parent: LCContextVisitor? = null, importVars: Boolean = false): LCBaseVisitor() {
    val variables = HashMap<String, Value?>()
    var fileVisitor: LCFileVisitor? = null

    init {
        if(parent!=null) {
            if(importVars) variables.putAll(parent.variables)
            methods.putAll(parent.methods)
            fileVisitor = parent.fileVisitor
        }
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Value? {
        val variableName = ctx!!.ID().text

        return variables[variableName]?: throw VariableNotFoundException(variableName,
            ctx.start.line, ctx.stop.line, fileVisitor?.path?: "unknown")
    }

    override fun visitMethod(ctx: lclangParser.MethodContext?): Value? {
        if(ctx==null) return null

        methods[ctx.ID().text] = VisitorMethod(ctx, this)
        return null
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Value? {
        if(ctx==null) return null
        val subjectName = Type.from(ctx.type()).name
        val notFoundException = MethodNotFoundException(subjectName,
            ctx.start.line, ctx.stop.line, fileVisitor?.path ?: "unknown")

        val method = methods[subjectName] ?: throw notFoundException
        if(method.args.size!=ctx.expression().size) throw notFoundException

        val args = ArrayList<Any?>()
        for(argNum in 0 until method.args.size){
            val value = visit(ctx.expression(argNum)) ?: throw notFoundException
            if(!method.args[argNum].isAccept(value.type()))
                throw notFoundException

            args.add(value.get())
        }

        val value = method.call(args)

        return Value({ method.returnType }, { value })
    }
}