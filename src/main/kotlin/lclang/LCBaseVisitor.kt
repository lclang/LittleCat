package lclang

import lclang.methods.Method
import lclang.methods.VisitorMethod

open class LCBaseVisitor: lclangBaseVisitor<Any?>() {
    val methods = HashMap<String, Method>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Any? {
        for(stmt in ctx!!.stmt())
            visit(stmt)

        return null
    }

    override fun visitValue(ctx: lclangParser.ValueContext?): Any? {
        if(ctx==null) return null
        return when {
            ctx.STRING()!=null -> {
                val string = ctx.STRING().text
                string.substring(1, string.length-1)
            }
            ctx.INTEGER()!=null -> ctx.INTEGER().text.toInt()
            ctx.LONG()!=null -> ctx.LONG().text.toInt()
            else -> throw Exception()
        }
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Any? {
        return visit(ctx!!.children[0])
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Any? {
        val expressionValue = visit(ctx!!.children[0])
        //TODO
        return expressionValue
    }

    override fun visitMethod(ctx: lclangParser.MethodContext?): Any? {
        if(ctx==null) return null

        methods[ctx.ID().text] = VisitorMethod(ctx)
        return null
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Any? {
        if(ctx==null) return null
        val subjectName = Type.from(ctx.type()).name
        val args = ArrayList<Any?>()
        for(arg in ctx.expression())
            args.add(visit(arg))

        val method = methods[subjectName] ?: throw Exception("Method $subjectName not found")
        return method.call(args)
    }
}