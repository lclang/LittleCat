package lclang

import lclang.methods.ClassMethod
import lclang.methods.VisitorMethod

open class LCClass(
    val name: String,
    parent: LCFileVisitor?
): LCContextVisitor(parent){

    open fun create(args: List<Any?>): LCClass {
        return LCClass(name, fileVisitor)
    }

    override fun toString(): String {
        return methods["toString"]?.call(fileVisitor!!, listOf())?.toString() ?:
            super.toString()
    }

    companion object {
        fun from(parent: LCFileVisitor, clazz: lclangParser.ClassExprContext): LCClass {
            return LCClass(clazz.ID().text, parent).apply {
                for(method in clazz.method())
                    methods[method.ID().text] = ClassMethod(this, method)
            }
        }
    }
}