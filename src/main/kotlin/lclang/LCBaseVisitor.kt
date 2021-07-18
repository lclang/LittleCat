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

    override fun visitValue(ctx: lclangParser.ValueContext?): Value? {
        if(ctx==null) return null
        return Value({ return@Value when {
            ctx.STRING()!=null -> ctx.STRING().text.substring(1)
                .substringBeforeLast('"')
            ctx.INTEGER()!=null -> ctx.INTEGER().text.toInt()
            ctx.LONG()!=null -> ctx.LONG().text.substringBeforeLast('L').toLong()
            else -> throw Exception()
        }})
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Value? {
        return visit(ctx!!.children[0])
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Value? {
        val value = visit(ctx!!.children[0])?.get
        return Value({ value })
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Value? {
        if(ctx==null) return null
        val subjectName = Type.from(ctx.type()).name
        val args = ArrayList<Value?>()
        for(arg in ctx.expression())
            args.add(visit(arg))

        val method = methods[subjectName] ?: throw MethodNotFoundException(subjectName,
            ctx.start.line, ctx.stop.line)
        val value = method.call(args)

        return Value({ value })
    }
}