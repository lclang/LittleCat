package lclang.methods

import lclang.lclangParser
import lclang.types.BaseType
import lclang.types.Types

open class ContextMethod(methodContext: lclangParser.MethodContext): VisitorMethod(
    if(methodContext.type()!=null)
        Types.getType(methodContext.type())
    else Types.VOID,
    methodContext.args().arg(),
    { it.visitBlock(methodContext.block()) }
)