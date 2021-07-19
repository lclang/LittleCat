package lclang

import lclang.libs.Library
import lclang.methods.Method

class LCFileVisitor(
    val path: String
): LCContextVisitor() {
    val classes = HashMap<String, lclangParser.ClassExprContext>()
    val components = HashMap<String, lclangParser.ComponentContext>()
    val libraries = ArrayList<Library>()
    val globals = HashMap<String, Value?>()

    init {
        fileVisitor = this
    }

    override fun visitGlobal(ctx: lclangParser.GlobalContext?): Value? {
        if(ctx==null) return null
        globals[ctx.ID().text] = visitValue(ctx.value())

        return null
    }

    override fun visitFile(ctx: lclangParser.FileContext?): Value? {
        if(ctx===null) return null
        for(classExpr in ctx.classExpr())
            classes[classExpr.ID().text] = classExpr

        for(library in libraries){
            methods.putAll(library.methods)
        }

        for(global in ctx.global())
            visitGlobal(global)

        for(method in ctx.method())
            visitMethod(method)

        for(stmt in ctx.stmt())
            visitStmt(stmt)

        return null
    }
}