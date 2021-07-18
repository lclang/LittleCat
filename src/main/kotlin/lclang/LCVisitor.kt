package lclang

class LCVisitor: lclangBaseVisitor<Any?>() {
    val methods = ArrayList<lclangParser.MethodContext>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Any? {
        for(child in ctx!!.children)
            visit(child)

        return null
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Any? {
        println(ctx!!.expression(1))
        return super.visitCall(ctx)
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Any? {
        return visit(ctx!!.children[0])
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Any? {
        return visit(ctx!!.children[0])
    }

    override fun visitFile(ctx: lclangParser.FileContext?): Any? {
        for (stmt in ctx!!.stmt()){
            visit(stmt)
        }

        return null
    }
}