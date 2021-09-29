package lclang.methods

import lclang.LCBaseExecutor
import lclang.Value
import lclang.lclangParser
import lclang.types.Types

open class ContextMethod(executor: LCBaseExecutor, methodContext: lclangParser.MethodContext): VisitorMethod(
    executor,
    if(methodContext.type()!=null)
        Types.getType(methodContext.type())
    else Types.VOID,
    methodContext.args().arg(),
    { it.visitBlock(methodContext.block()) ?: Value(Types.VOID, null) }
)