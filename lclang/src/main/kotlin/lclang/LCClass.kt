package lclang

import lclang.methods.Method
import lclang.types.NamedType

open class LCClass(
    val name: String,
    path: String = name
): LCRootExecutor(path) {
    constructor(name: String, root: LCRootExecutor): this(name, root.path)

    private val classId = Global.classIndex++
    open var extends: LCClass? = null
    open var constructor: Method? = null

    open fun asValue() = Value(NamedType(this), this)

//    companion object {
//        fun from(componentName: String,
//                 root: LCRootExecutor,
//                 fromClass: lclangParser.ClassExprContext): LCClass {
//            val staticClass = LCClass(componentName+fromClass.name.text, root)
//            val clazzType = NamedType(staticClass)
//            staticClass.constructor = VisitorMethod(root.executor, clazzType,
//                fromClass.args()?.arg()?:listOf()) {
//                val clazz = LCClass(staticClass.name, root)
//                if(fromClass.classExtends!=null) {
//                    clazz.extends = root.classes[fromClass.classExtends.text] ?: throw ClassNotFoundException(
//                        staticClass.name,
//                        fromClass.classExtends.asCaller(root)
//                    )
//
//                    clazz.accept(clazz.extends!!)
//                }
//                clazz.executor.variables.putAll(it.variables)
//                clazz.accept(root)
//
//                for(method in fromClass.method())
//                    clazz.globals[method.ID().text] = ClassMethod(clazz, method).asValue()
//
//                for (stmt in fromClass.stmt()) clazz.compiler.visitStmt(stmt)
//                    .visit(Caller(clazz, 0, 0), clazz.executor)
//
//                return@VisitorMethod Value(clazzType, clazz)
//            }
//
//            return staticClass
//        }
//    }

    fun canCast(another: LCClass): Boolean =
        another.name == name || extends!=null && extends!!.canCast(another)

    override fun equals(other: Any?) = other is LCClass && classId == other.classId
    override fun hashCode(): Int = classId
    override fun toString(): String {
        val caller = Caller(this, 0, 0)

        val toStringMethod = globals["toString"]
        if(toStringMethod!=null) {
            val method = toStringMethod.get(caller)
            if(method is Method)
                return method.call(caller, listOf()).toString()
        }

        return "$name@class$classId: {" + executor.variables.entries.joinToString {
            it.key + ": " + it.value.type + " = " + it.value.get(caller)
        } + "}"
    }
}