package lclang

import lclang.exceptions.LCLangException
import lclang.types.Type

open class Value(
    val type: Type,
    var get: (Caller) -> LCClass?,
    var set: (Caller, Value) -> Unit = { caller, _ ->
        throw LCLangException("Invalid operation", "Value is not settable", caller) },
    var state: State = State.NOTHING
){
    enum class State {
        RETURN,
        STOP,
        NOTHING
    }

    constructor(type: Type, value: LCClass? = null, state: State = State.NOTHING): this(type, { value }, state = state)
}