package lclang.methods

import lclang.LCBaseVisitor
import lclang.lclangParser
import lclang.types.Types

class LambdaMethod(executor: LCBaseVisitor, lambdaContext: lclangParser.LambdaContext): VisitorMethod(
    if(lambdaContext.type()!=null)
        Types.getType(lambdaContext.type())
    else Types.VOID,
    lambdaContext.args()?.arg()?: listOf(),
    { executor.visitExpression(lambdaContext.expression()) }
)