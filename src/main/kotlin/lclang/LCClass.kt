package lclang

import lclang.methods.ClassMethod
import lclang.methods.Method
import lclang.types.NamedType

open class LCClass(
    private val name: String,
    fileVisitor: LCFileVisitor
): LCBaseVisitor(fileVisitor){
    val classType = NamedType("\\"+name)
    open val constructor: Method = method(listOf(), classType) {
        LCClass(name, fileVisitor).apply {
            globals.putAll(this@LCClass.globals)
            variables.putAll(this@LCClass.variables)
        }
    }

    init {
        this.fileVisitor = fileVisitor
        globals.clear()
        variables.clear()
    }

    fun create(caller: Caller, args: List<Value> = listOf()): Value {
        return Value(constructor.returnType, constructor.call(caller, args) as LCClass)
    }

    fun asValue(): Value {
        return Value(constructor.returnType, this)
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
                it.call(Caller(fileVisitor, 0, 0), listOf())

            null
        } ?: "$name@class"
    }
}