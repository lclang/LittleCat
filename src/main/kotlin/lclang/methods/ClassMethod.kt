package lclang.methods

import lclang.LCClass
import lclang.Value
import lclang.lclangParser
import lclang.types.Types

class ClassMethod(clazz: LCClass, private val methodContext: lclangParser.MethodContext):
    VisitorMethod(
        if(methodContext.type()!=null)
            Types.getType(methodContext.type())
        else Types.VOID,
        methodContext.args().arg(),
        {
            it.variables["this"] = Value(clazz.classType, { clazz })
            it.visitBlock(methodContext.block()) ?: Value(Types.VOID, null)
        }
    )