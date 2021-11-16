package lclang.libs.reflection

import lclang.Caller
import lclang.LCClass
import lclang.Value
import lclang.libs.lang.NullClass
import lclang.method
import lclang.methods.Method
import lclang.types.Types

class ReflectionValue(value: Value): LCClass("ReflectionValue") {
    init {
        globals["get"] = method(returnType = value.type) { value.get(this) }
        globals["set"] = object : Method(this@ReflectionValue, arrayOf(Types.ANY), Types.VOID) {
            override fun call(caller: Caller, args: List<Value>): Value {
                value.set(caller, args[0])
                return NullClass.NULL.asValue()
            }
        }.asValue()
    }
}