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
            methods.putAll(this.methods)
        }
    }

    override fun toString(): String {
        return methods["toString"]?.call(fileVisitor, listOf())?.toString() ?: "$name@class"
    }

    companion object {
        fun from(componentName: String,
                 fileVisitor: LCFileVisitor,
                 clazz: lclangParser.ClassExprContext): LCClass {
            return LCClass(componentName+clazz.ID().text, fileVisitor).apply {
                for(method in clazz.method())
                    methods[method.ID().text] = ClassMethod(this, method)
            }
        }
    }
}