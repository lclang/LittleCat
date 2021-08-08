package lclang

import lclang.methods.ClassMethod
import lclang.methods.Method
import lclang.types.Type

open class LCClass(
    val name: String,
    fileVisitor: LCFileVisitor
): LCBaseVisitor(fileVisitor){
    val classType = Type("\\"+name)
    val constructor: Method = object: Method(listOf(), classType) {
        override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
            return LCClass(name, fileVisitor).apply {
                globals.putAll(this@LCClass.globals)
                variables.putAll(this@LCClass.variables)
            }
        }
    }

    init {
        this.fileVisitor = fileVisitor
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