package lclang

import lclang.exceptions.VariableNotFoundException
import lclang.methods.VisitorMethod

open class LCContextVisitor(parent: LCContextVisitor? = null, importVars: Boolean = false): LCBaseVisitor() {
    val variables = HashMap<String, Value?>()
    init {
        if(parent!=null) {
            if(importVars) variables.putAll(parent.variables)
            methods.putAll(parent.methods)
        }

        variables["test"] = Value({ return@Value "" })
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Value? {
        val variableName = ctx!!.ID().text

        return Value({
            if(!variables.containsKey(variableName))
                throw VariableNotFoundException(variableName, ctx.start.line, ctx.start.startIndex)

            return@Value variables[variableName]!!.get()
        })
    }

    override fun visitMethod(ctx: lclangParser.MethodContext?): Value? {
        if(ctx==null) return null

        methods[ctx.ID().text] = VisitorMethod(ctx, this)
        return null
    }
}