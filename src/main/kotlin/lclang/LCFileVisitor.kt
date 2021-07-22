package lclang

import lclang.libs.Library
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class LCFileVisitor(
    val path: String
): LCBaseVisitor() {
    val classes = HashMap<String, LCClass>()
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
            classes[classExpr.ID().text] = LCClass.from(this, classExpr)

        for(library in libraries){
            methods.putAll(library.methods)
            globals.putAll(library.globals)
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