package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.LCClass
import lclang.Value

class ClassStatement(
    val name: String,
    val extends: String?,
    line: Int,
    column: Int
): Statement(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        return object: LCClass(name, prevCaller.root) {
//            override var constructor: Method? = constructor {
//                val clazz = LCClass(name, caller.root)
//                if(extends!=null) {
//                    clazz.extends = caller.root.classes[extends] ?: throw ClassNotFoundException(
//                        name,
//                        caller
//                    )
//
//                    clazz.accept(clazz.extends!!)
//                }
//
//                clazz.executor.variables.putAll(executor.variables)
//                clazz.accept(caller.root)
//
//                for(method in fromClass.method())
//                    clazz.globals[method.ID().text] = ClassMethod(clazz, method).asValue()
//
//                for (stmt in fromClass.stmt()) clazz.compiler.visitStmt(stmt)
//                    .visit(Caller(clazz, 0, 0), clazz.executor)
//
//                return@VisitorMethod Value(clazzType, clazz)
//            }
        }.asValue()
    }
}