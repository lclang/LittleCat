package lclang

import lclang.methods.Method

class LCFileVisitor(
    val path: String
): LCContextVisitor() {
    val classes = HashMap<String, lclangParser.ClassExprContext>()
    val components = HashMap<String, lclangParser.ComponentContext>()

    init {
        fileVisitor = this
        methods["println"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(args: List<Any?>): Any? {
                println(args[0])

                return null
            }
        }
        methods["print"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(args: List<Any?>): Any? {
                print(args[0])

                return null
            }
        }
    }

    override fun visitFile(ctx: lclangParser.FileContext?): Value? {
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