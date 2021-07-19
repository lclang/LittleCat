package lclang

import lclang.exceptions.MethodNotFoundException
import lclang.methods.Method

open class LCBaseVisitor: lclangBaseVisitor<Value?>() {
    val methods = HashMap<String, Method>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Value? {
        for(stmt in ctx!!.stmt())
            visit(stmt)?.let { it.get() }

        return null
    }

    override fun visitTypeGet(ctx: lclangParser.TypeGetContext?): Value? {
        val type = visitExpression(ctx!!.expression())!!.type()
        return Value({ Type.STRING }, { type.name })
    }

    override fun visitValue(ctx: lclangParser.ValueContext?): Value? {
        if(ctx==null) return null
        return when {
            ctx.STRING()!=null -> Value({ Type.STRING }, { ctx.STRING().text.substring(1)
                .substringBeforeLast('"')})
            ctx.INTEGER()!=null -> Value({ Type.INT }, { ctx.INTEGER().text.toInt() })
            ctx.LONG()!=null -> Value({ Type.LONG }, { ctx.LONG().text
                .substringBeforeLast('L').toLong()})
            else -> throw Exception()
        }
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Value? {
        val value = visit(ctx!!.children[0])
        value?.get?.invoke()
        return value
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Value? {
        return visit(ctx!!.children[0])!!
    }
}