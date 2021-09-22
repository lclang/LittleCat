package lclang

import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.methods.ContextMethod
import lclang.types.Types
import java.io.File

open class LCFileVisitor(
    val path: String
): LCBaseVisitor() {
    val classes = HashMap<String, LCClass>()
    val libraries = ArrayList<Library>()

    fun execute(ctx: lclangParser.FileContext) {
        Global.libraries.forEach {
            classes.putAll(it.classes)
            globals.putAll(it.globals)
        }

        fileVisitor = this

        for(classExpr in ctx.classExpr())
            classes[classExpr.ID().text] = LCClass.from("",this, classExpr)

        for(component in ctx.component()){
            val name = Types.getNamedType(component.type().baseType()).name + "\\"
            for(global in ctx.global())
                globals[name+global.ID().text] = visitValue(global.value())

            for(classExpr in ctx.classExpr())
                classes[name+classExpr.ID().text] = LCClass.from(name,this, classExpr)
        }

        for(library in libraries) {
            classes.putAll(library.classes)
            globals.putAll(library.globals)
        }

        val files = HashMap<String, LCFileVisitor>()
        for(usage in ctx.use()){
            val requiredFile = File(File(fileVisitor.path).parent, usage.STRING().text
                .substring(1).substringBeforeLast('"'))

            var eval: LCFileVisitor? = null
            if(!requiredFile.exists())
                throw LCLangException("File", "file "+requiredFile.name+" not found",
                    Caller(this, usage.start.line, usage.stop.line))
            else if(files[requiredFile.path]!=null)
                eval = files[requiredFile.path]!!
            else if(requiredFile.length()!=0L){
                eval = LCFileVisitor(requiredFile.path.toString())
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
            globals[global.ID().text] = visitValue(global.value())

        for(method in ctx.method()) {
            globals[method.ID().text] = ContextMethod(method)
        }

        for(stmt in ctx.stmt()) {
            val value = visitStmt(stmt)
            if(value!=null) {
                value.get(Caller(this, stmt.start.line, stmt.stop.line))
                if(value.stop || value.isReturn)
                    return
            }
        }
    }
}