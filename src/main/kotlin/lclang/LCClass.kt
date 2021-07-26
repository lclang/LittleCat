package lclang

import lclang.methods.ClassMethod

open class LCClass(
    val name: String,
    fileVisitor: LCFileVisitor
): LCBaseVisitor(fileVisitor){

    init {
        this.fileVisitor = fileVisitor
    }

    open fun create(args: List<Any?>): LCClass {
        return LCClass(name, fileVisitor).apply {
            globals.putAll(this.globals)
            variables.putAll(this.variables)
        }
    }

    companion object {
        fun from(componentName: String,
                 fileVisitor: LCFileVisitor,
                 clazz: lclangParser.ClassExprContext): LCClass {
            return LCClass(componentName+clazz.ID().text, fileVisitor).apply {
                for(method in clazz.method())
                    globals[method.ID().text] = ClassMethod(this, method)
            }
        }
    }
}