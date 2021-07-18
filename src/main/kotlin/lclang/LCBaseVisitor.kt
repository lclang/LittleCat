package lclang

class LCBaseVisitor: lclangBaseVisitor<Any?>() {
    override fun visitBlock(ctx: lclangParser.BlockContext?): Any? {
        for(stmt in ctx!!.stmt())
            visit(stmt)

        return null
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Any? {
        return ctx!!.children[0]
    }
}