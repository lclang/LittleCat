package lclang

import lclang.exceptions.MethodNotFoundException
import lclang.exceptions.VariableNotFoundException

open class LCContextVisitor(
    parent: LCContextVisitor? = null, importVars: Boolean = false): LCBaseVisitor() {
    val variables = HashMap<String, Value?>()

    init {
        if(parent!=null) {
            if(importVars) variables.putAll(parent.variables)
            methods.putAll(parent.methods)
            fileVisitor = parent.fileVisitor
        }
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Value? {
        val variableName = ctx!!.ID().text

        return Value({ variables[variableName]?.type?.invoke()?:
        fileVisitor?.globals?.get(variableName)?.type?.invoke()?: Type.ANY }, {
            variables[variableName]?.get?.invoke()?:
            fileVisitor?.globals?.get(variableName)?.get?.invoke() ?:
            throw VariableNotFoundException(variableName,
                    ctx.start.line, ctx.stop.line, fileVisitor?.path?: "unknown")
            }, { variables[variableName] = it })
    }

    override fun visitPrimitive(ctx: lclangParser.PrimitiveContext?): Value? {
        val value =  super.visitPrimitive(ctx)
        val operation = ctx?.operation()
        if(operation?.set()!=null){
            val expressionValue = visitExpression(operation.set().expression())
            value!!.set(expressionValue)

            return expressionValue
        }

        return value
    }
}