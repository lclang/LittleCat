package lclang

import lclang.methods.Method

class LCFileVisitor: LCContextVisitor() {
    val classes = HashMap<String, lclangParser.ClassExprContext>()
    val components = HashMap<String, lclangParser.ComponentContext>()

    init {
        methods["println"] = object: Method(listOf(), Type("any")) {
            override fun call(args: List<Any?>): Any? {
                println(args[0])

                return null
            }
        }
        methods["print"] = object: Method(listOf(), Type("any")) {
            override fun call(args: List<Any?>): Any? {
                print(args[0])

                return null
            }
        }
    }

    override fun visitFile(ctx: lclangParser.FileContext?): Any? {
        if(ctx===null) return null
        for(classExpr in ctx.classExpr())
            classes[classExpr.ID().text] = classExpr

        for(method in ctx.method())
            visitMethod(method)

        for(stmt in ctx.stmt())
            visitStmt(stmt)

        return null
    }
}