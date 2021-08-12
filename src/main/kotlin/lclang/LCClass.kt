package lclang

import lclang.methods.ClassMethod
import lclang.methods.LibraryMethod
import lclang.methods.Method
import lclang.types.Type

open class LCClass(
    val name: String,
    fileVisitor: LCFileVisitor
): LCBaseVisitor(fileVisitor){
    val classType = Type("\\"+name)
    open val constructor: Method = object: LibraryMethod(listOf(), classType) {
        override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
            return LCClass(name, fileVisitor).apply {
                globals.putAll(this@LCClass.globals)
                variables.putAll(this@LCClass.variables)
            }
        }
    }

    init {
        this.fileVisitor = fileVisitor
    }

    fun create(args: List<Value> = listOf()): Value {
        return Value(constructor.returnType, constructor.call(this.fileVisitor, args) as LCClass)
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

    override fun toString(): String {
        return globals["toString"]?.let {
            if(it is Method)
                it.call(fileVisitor, listOf())

            null
        } ?: "$name@class"
    }
}