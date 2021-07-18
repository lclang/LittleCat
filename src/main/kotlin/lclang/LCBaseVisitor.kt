package lclang

open class LCBaseVisitor: lclangBaseVisitor<Any?>() {
    val methods = ArrayList<lclangParser.MethodContext>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Any? {
        for(stmt in ctx!!.stmt())
            visit(stmt)

        return null
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
        methods.add(ctx!!)
        return null
    }
}