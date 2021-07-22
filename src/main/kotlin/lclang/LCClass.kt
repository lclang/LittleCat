package lclang

import lclang.methods.ClassMethod
import lclang.methods.Method

open class LCClass(
    val name: String,
    fileVisitor: LCFileVisitor?,
    val value: Any?
): LCBaseVisitor(){

    init {
        this.fileVisitor = fileVisitor
        methods["println"] = object: Method(listOf(), Type.STRING) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println(value)
                return null
            }
        }
    }

    open fun create(args: List<Any?>): LCClass {
        return LCClass(name, fileVisitor, null)
    }

    override fun toString(): String {
        return methods["toString"]?.call(fileVisitor!!, listOf())?.toString() ?:
            super.toString()
    }

    companion object {
        fun from(parent: LCFileVisitor, clazz: lclangParser.ClassExprContext): LCClass {
            return LCClass(clazz.ID().text, parent, null).apply {
                for(method in clazz.method())
                    methods[method.ID().text] = ClassMethod(this, method)
            }
        }
    }
}