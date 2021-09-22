package lclang.methods

import lclang.lclangParser
import lclang.types.Types

class LambdaMethod(lambdaContext: lclangParser.LambdaContext): VisitorMethod(
    if(lambdaContext.type()!=null)
        Types.getType(lambdaContext.type())
    else Types.VOID,
    lambdaContext.args()?.arg()?: listOf(),
    { it.visitExpression(lambdaContext.expression()) }
)