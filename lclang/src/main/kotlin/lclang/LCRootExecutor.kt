package lclang

import lclang.statements.Statement

open class LCRootExecutor(
    val path: String
) {
    val executor = LCBaseExecutor(this)
    val globals = HashMap<String, Value>()
    val classes = HashMap<String, LCClass>()
    val statements = ArrayList<Statement>()

    fun accept(root: LCRootExecutor){
        classes.putAll(root.classes)
        globals.putAll(root.globals)
    }

    fun execute(): LCClass? {
//        val classes = ctx.classExpr()
//        for(clazz in classes)
//            this.classes[clazz.name.text] = LCClass.from("",this, clazz)
//
//        val components = ctx.component()
//        for(component in components){
//            val name = component.type().namedType().text + "\\"
//
//            val componentGlobals = component.global()
//            for(global in componentGlobals)
//                globals[name+global.ID().text] = compiler.visitValue(global.value())
//                    .visit(Caller(this, 0, 0), executor)
//
//            val componentClasses = component.classExpr()
//            for(clazz in componentClasses)
//                this.classes[name+clazz.name] = LCClass.from(name,this, clazz)
//        }
//
//        val files = HashMap<String, LCRootExecutor>()
//        for(usage in ctx.use()){
//            val requiredFile = File(File(path).parent, usage.STRING().text
//                .substring(1).substringBeforeLast('"'))
//
//            var eval: LCRootExecutor? = null
//            if(!requiredFile.exists())
//                throw LCLangException("File", "file "+requiredFile.name+" not found",
//                    Caller(this, usage.start.line, usage.stop.line))
//            else if(files[requiredFile.path]!=null)
//                eval = files[requiredFile.path]!!
//            else if(requiredFile.length()!=0L){
//                eval = LCRootExecutor(requiredFile.path.toString())
//                eval.runInput(requiredFile.readText())
//
//                files[requiredFile.path] = eval
//            }
//
//            if(eval!=null){
//                val name = usage.namedType().text
//                if(usage.useGlobal!=null){
//                    if(eval.globals.containsKey(name))
//                        globals[name] = eval.globals[name]!!
//                    else throw LCLangException("File", "global "+requiredFile.name+" not found",
//                        Caller(this, usage.start.line, usage.stop.line))
//                }else{
//                    if(eval.classes.containsKey(name))
//                        this.classes[name] = eval.classes[name]!!
//                    else throw LCLangException("File", "class "+requiredFile.name+" not found",
//                        Caller(this, usage.start.line, usage.stop.line))
//                }
//            }
//        }
//
//        files.clear()
//
//        for(global in ctx.global())
//            globals[global.ID().text] = compiler.visitValue(global.value())
//                .visit(Caller(this, 0, 0), executor)
//
//        for(method in ctx.method()) {
//            globals[method.ID().text] = ContextMethod(this.executor, method).asValue()
//        }

        val rootCaller = Caller(this, 0, 0)
        for(stmt in statements) {
            val caller = stmt.getCaller(rootCaller)
            val value = stmt.visit(caller, executor)

            val clazz = value.get(caller)
            if(value.state!=Value.State.NOTHING)
                return clazz
        }

        return null
    }
}