package lclang

import lclang.exceptions.VariableNotFoundException
import lclang.methods.VisitorMethod

open class LCContextVisitor(parent: LCContextVisitor? = null, importVars: Boolean = false): LCBaseVisitor() {
    val variables = HashMap<String, Any?>()
    init {
        if(parent!=null) {
            variables.putAll(parent.variables)
            if(importVars) methods.putAll(parent.methods)
        }

        variables["test"] = "test"
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Any? {
        val variableName = ctx!!.ID().text
        if(!variables.containsKey(variableName))
            throw VariableNotFoundException(variableName)

        return variables[variableName]
    }

    override fun visitMethod(ctx: lclangParser.MethodContext?): Any? {
        if(ctx==null) return null

        methods[ctx.ID().text] = VisitorMethod(ctx, this)
        return null
    }
}