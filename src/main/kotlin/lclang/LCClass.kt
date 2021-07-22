package lclang

import lclang.methods.ClassMethod

open class LCClass(
    val name: String,
): LCBaseVisitor(){

    open fun create(args: List<Any?>): LCClass {
        return LCClass(name)
    }

    override fun toString(): String {
        return methods["toString"]?.call(fileVisitor, listOf())?.toString() ?:
            super.toString()
    }

    companion object {
        fun from(componentName: String,
                 parent: LCFileVisitor,
                 clazz: lclangParser.ClassExprContext): LCClass {
            return LCClass(componentName+clazz.ID().text).apply {
                this.fileVisitor = parent

                for(method in clazz.method())
                    methods[method.ID().text] = ClassMethod(this, method)
            }
        }
    }
}