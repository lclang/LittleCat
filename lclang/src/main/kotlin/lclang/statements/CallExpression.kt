package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.TypeErrorException
import lclang.isAccept
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Type

class CallExpression(
    val expression: Expression,
    val arguments: Array<Expression>,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val value = expression.visit(caller, visitor)
        if(value.type !is CallableType)
            throw TypeErrorException("Value is not callable (it is ${value.type})", caller)

        val argsTypes = ArrayList<Type>()
        val args = ArrayList<Value>()
        for(argument in arguments) {
            val argumentValue = argument.visit(caller, visitor)
            argsTypes.add(argumentValue.type)

            args.add(argumentValue)
        }

        val method = value.get(caller) as Method
        if(method.args.size!=argsTypes.size){
            throw TypeErrorException(if(method.args.size>argsTypes.size)
                "Invalid arguments: few arguments" else "Invalid arguments: too many arguments", caller)
        }

        val notAcceptArg = method.args.isAccept(argsTypes.toTypedArray())
        if(notAcceptArg!=-1)
            throw TypeErrorException("Invalid argument $notAcceptArg: excepted ${method.args[notAcceptArg]}",
                caller)
//                expressions[notAcceptArg].asCaller(this))

        return Value(method.returnType, method.call(caller, args))
    }
}