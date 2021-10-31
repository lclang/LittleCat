package lclang

import lclang.exceptions.VariableNotFoundException
import lclang.types.Types

open class LCBaseExecutor(val root: LCRootExecutor) {
    constructor(executor: LCBaseExecutor): this(executor.root)
    val variables = HashMap<String, Value>()

    fun getLink(name: String): Value {
        val value = variables[name] ?: root.globals[name] ?:
        Value(Types.UNDEFINED, {
            throw VariableNotFoundException(name, it)
        })

        value.set = { _, newValue ->
            variables[name] = newValue
        }

        return value
    }

     //fun visitLambda(ctx: lclangParser.LambdaContext): Value = LambdaMethod(this, ctx).asValue()
}