package lclang

class LCFileVisitor: LCBaseVisitor() {
    val classes = HashMap<String, lclangParser.ClassExprContext>()
    val components = HashMap<String, lclangParser.ComponentContext>()

    override fun visitFile(ctx: lclangParser.FileContext?): Any? {
        if(ctx===null) return null

        for(classExpr in ctx.classExpr())
            classes[classExpr.ID().text] = classExpr

        for(stmt in ctx.stmt())
            visitStmt(stmt)

        return null
    }
}