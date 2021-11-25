package lclang.libs.reflection

import lclang.Global
import lclang.LCClass
import lclang.libs.Library
import lclang.libs.lang.ArrayClass
import lclang.method
import lclang.string
import lclang.types.Types

class ReflectionLibrary: Library("refLib") {
    init {
        globals["reflection"] = ReflectionClass().asValue()
    }

    class ReflectionClass: LCClass("Reflection") {
        init {
            globals["getLink"] = method(listOf(Types.ANY, Types.STRING), Types.ANY) {
                ReflectionValue(it[0].executor.getLink(this, it[1].string().string))
            }

            globals["getVariables"] = method(listOf(Types.ANY), Types.ARRAY) {
                ArrayClass(it[0].executor.variables.values.toList().map { value ->
                    ReflectionValue(value)
                })
            }

            globals["getLibraries"] = method(returnType = Types.ARRAY) {
                ArrayClass(Global.javaLibraries.map { it })
            }
        }
    }
}