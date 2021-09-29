package lclang

import lclang.exceptions.LCLangException
import lclang.methods.ContextMethod
import lclang.types.Types
import java.io.File

open class LCRootExecutor(
    val path: String
) {
    val executor = LCBaseExecutor(this)
    val globals = HashMap<String, Value>()
    val classes = HashMap<String, LCClass>()

    fun accept(root: LCRootExecutor){
        classes.putAll(root.classes)
        globals.putAll(root.globals)
    }

    fun execute(ctx: lclangParser.FileContext) {
        for(library in Global.libraries+Global.javaLibraries) accept(library)
        for(classExpr in ctx.classExpr())
            classes[classExpr.ID().text] = LCClass.from("",this, classExpr)

        for(component in ctx.component()){
            val name = Types.getNamedType(component.type().baseType()).name + "\\"
            for(global in ctx.global())
                globals[name+global.ID().text] = executor.visitValue(global.value())

            for(classExpr in ctx.classExpr())
                classes[name+classExpr.ID().text] = LCClass.from(name,this, classExpr)
        }

        val files = HashMap<String, LCRootExecutor>()
        for(usage in ctx.use()){
            val requiredFile = File(File(path).parent, usage.STRING().text
                .substring(1).substringBeforeLast('"'))

            var eval: LCRootExecutor? = null
            if(!requiredFile.exists())
                throw LCLangException("File", "file "+requiredFile.name+" not found",
                    Caller(this, usage.start.line, usage.stop.line))
            else if(files[requiredFile.path]!=null)
                eval = files[requiredFile.path]!!
            else if(requiredFile.length()!=0L){
                eval = LCRootExecutor(requiredFile.path.toString())
                eval.runInput(requiredFile.readText())

                files[requiredFile.path] = eval
            }

            if(eval!=null){
                val name = usage.baseType().text
                if(usage.useGlobal!=null){
                    if(eval.globals.containsKey(name))
                        globals[name] = eval.globals[name]!!
                    else throw LCLangException("File", "global "+requiredFile.name+" not found",
                        Caller(this, usage.start.line, usage.stop.line))
                }else{
                    if(eval.classes.containsKey(name))
                        classes[name] = eval.classes[name]!!
                    else throw LCLangException("File", "class "+requiredFile.name+" not found",
                        Caller(this, usage.start.line, usage.stop.line))
                }
            }
        }

        files.clear()

        for(global in ctx.global())
            globals[global.ID().text] = executor.visitValue(global.value())

        for(method in ctx.method()) {
            globals[method.ID().text] = ContextMethod(this.executor, method).asValue()
        }

        for(stmt in ctx.stmt()) execute(stmt)
    }

    fun execute(stmt: lclangParser.StmtContext) {
        val value = executor.visitStmt(stmt)
        if(value!=null) {
            value.get(Caller(this, stmt.start.line, stmt.stop.line))
            if(value.stop || value.isReturn)
                return
        }
    }
}