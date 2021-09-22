package lclang

import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.methods.ContextMethod
import lclang.types.Type
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

open class LCFileVisitor(
    val path: String
): LCBaseVisitor() {
    val classes = HashMap<String, LCClass>()
    val libraries = ArrayList<Library>()

    override fun visitComponent(ctx: lclangParser.ComponentContext): Value? {
        val name = Type.from(ctx.type().baseType()).name + "\\"
        for(global in ctx.global())
            globals[name+global.ID().text] = visitValue(global.value())

        for(classExpr in ctx.classExpr())
            classes[name+classExpr.ID().text] = LCClass.from(name,this, classExpr)

        return null
    }

    fun includeFrom(fileVisitor: LCFileVisitor) {
        classes.putAll(fileVisitor.classes)
        globals.putAll(fileVisitor.globals)
    }

    fun execute(ctx: lclangParser.FileContext) {
        fileVisitor = this

        for(classExpr in ctx.classExpr())
            classes[classExpr.ID().text] = LCClass.from("",this, classExpr)

        for(component in ctx.component())
            visitComponent(component)

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
                    usage.start.line, usage.stop.line, fileVisitor.path)
            else if(files[requiredFile.path]!=null)
                eval = files[requiredFile.path]!!
            else if(requiredFile.length()!=0L){
                val lexer = lclangLexer(CharStreams.fromString(requiredFile.readText()))
                val tokens = CommonTokenStream(lexer)
                val parser = lclangParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ErrorListener(requiredFile.path.toString()))

                eval = LCFileVisitor(requiredFile.path.toString()).apply {
                    libraries.addAll(this@LCFileVisitor.libraries)
                    execute(parser.file())
                }

                files[requiredFile.path] = eval
            }

            if(eval!=null){
                val name = usage.baseType().text
                if(usage.useGlobal!=null){
                    if(eval.globals.containsKey(name))
                        globals[name] = eval.globals[name]!!
                    else throw LCLangException("File", "global "+requiredFile.name+" not found",
                        usage.start.line, usage.stop.line, fileVisitor.path)
                }else{
                    if(eval.classes.containsKey(name))
                        classes[name] = eval.classes[name]!!
                    else throw LCLangException("File", "class "+requiredFile.name+" not found",
                        usage.start.line, usage.stop.line, fileVisitor.path)
                }
            }
        }

        files.clear()

        for(global in ctx.global())
            globals[global.ID().text] = visitValue(global.value())

        for(method in ctx.method()) {
            globals[method.ID().text] = ContextMethod(method)
        }

        for(stmt in ctx.stmt())
            visitStmt(stmt)?.let {
                it.get()
                if(it.stop||it.isReturn)
                    return
            }
    }
}