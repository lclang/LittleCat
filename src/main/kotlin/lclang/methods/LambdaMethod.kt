package lclang.methods

import lclang.LCBaseExecutor
import lclang.lclangParser
import lclang.types.Types

class LambdaMethod(executor: LCBaseExecutor, lambdaContext: lclangParser.LambdaContext): VisitorMethod(
    executor,
    if(lambdaContext.type()!=null)
        Types.getType(lambdaContext.type())
    else Types.VOID,
    lambdaContext.args()?.arg()?: listOf(),
    {
        it.variables.putAll(executor.variables.filterKeys { key -> !it.variables.containsKey(key) })
        it.visitExpression(lambdaContext.expression())
    }
)