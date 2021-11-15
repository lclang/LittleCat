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
        return object: LCClass(name, prevCaller.root.path) {
//            init {
//                constructor = constructor {
//                    val clazz = LCClass(name, prevCaller.root.path)
//                    if(extends!=null) {
//                        clazz.extendsClass = prevCaller.root.classes[extends] ?: throw ClassNotFoundException(
//                            name,
//                            prevCaller
//                        )
//
//                        clazz.accept(clazz.extendsClass!!)
//                    }
//
//                    clazz.executor.variables.putAll(executor.variables)
//                    clazz.accept(prevCaller.root)
//
//                    for(method in fromClass.method())
//                        clazz.globals[method.ID().text] = ClassMethod(clazz, method).asValue()
//
//                    for (stmt in fromClass.stmt()) clazz.compiler.visitStmt(stmt)
//                        .visit(Caller(clazz, 0, 0), clazz.executor)
//
//                    return@VisitorMethod Value(clazzType, clazz)
//                }
//            }
        }.asValue()
    }
}