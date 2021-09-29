package lclang

import lclang.methods.ClassMethod
import lclang.methods.Method
import lclang.methods.VisitorMethod
import lclang.types.NamedType
import lclang.types.Type

open class LCClass(
    private val name: String,
    path: String = name
): LCRootExecutor(path){
    constructor(name: String, root: LCRootExecutor): this(name, root.path)

    open val classType: Type = NamedType(name)
    open var constructor: Method = constructor {}

    fun create(caller: Caller, args: List<Value> = listOf()): Value {
        return Value(constructor.returnType, constructor.call(caller, args) as LCClass)
    }

    open fun asValue(): Value {
        return Value(constructor.returnType, this)
    }

    companion object {
        fun from(componentName: String,
                 root: LCRootExecutor,
                 fromClass: lclangParser.ClassExprContext): LCClass {
            val staticClass = LCClass(componentName+fromClass.ID().text, root)
            staticClass.constructor = VisitorMethod(root.executor, staticClass.classType,
                fromClass.args()?.arg()?:listOf()) {
                val clazz = LCClass(staticClass.name, root)
                clazz.executor.variables.putAll(it.variables)
                clazz.accept(root)

                for(method in fromClass.method())
                    clazz.globals[method.ID().text] = ClassMethod(clazz, method).asValue()

                for (stmt in fromClass.stmt()) clazz.execute(stmt)
                return@VisitorMethod Value(staticClass.classType, clazz)
            }

            return staticClass
        }
    }

    override fun toString(): String {
        val toStringMethod = globals["toString"]
        if(toStringMethod!=null) {
            val caller = Caller(this, 0, 0)
            val method = toStringMethod.get(caller)
            if(method is Method)
                return method.call(caller, listOf()).toString()
        }

        return "$name@class"
    }
}