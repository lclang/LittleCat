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

        variables["test"] = Value({ return@Value "" })
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Value? {
        val variableName = ctx!!.ID().text

        return Value({
            if(!variables.containsKey(variableName))
                throw VariableNotFoundException(variableName, ctx.start.line, ctx.start.startIndex,
                    fileVisitor?.path ?: "unknown")

            return@Value variables[variableName]!!.get()
        })
    }

    override fun visitMethod(ctx: lclangParser.MethodContext?): Value? {
        if(ctx==null) return null

        methods[ctx.ID().text] = VisitorMethod(ctx, this)
        return null
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Value? {
        if(ctx==null) return null
        val subjectName = Type.from(ctx.type()).name
        val args = ArrayList<Any?>()
        for(arg in ctx.expression())
            args.add(visit(arg)?.get?.invoke())

        val method = methods[subjectName] ?: throw MethodNotFoundException(subjectName,
            ctx.start.line, ctx.stop.line, fileVisitor?.path ?: "unknown")
        val value = method.call(args)

        return Value({ value })
    }
}