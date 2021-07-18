package lclang

import lclang.methods.Method

open class LCBaseVisitor: lclangBaseVisitor<Value?>() {
    val methods = HashMap<String, Method>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Value? {
        for(stmt in ctx!!.stmt())
            visit(stmt)

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
        return visit(ctx!!.children[0])
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Value? {
        return Value({
            if(ctx==null) return@Value null
            val subjectName = Type.from(ctx.type()).name
            val args = ArrayList<Value?>()
            for(arg in ctx.expression())
                args.add(visit(arg))

            val method = methods[subjectName] ?: throw Exception("Method $subjectName not found")
            return@Value method.call(args)
        })
    }
}