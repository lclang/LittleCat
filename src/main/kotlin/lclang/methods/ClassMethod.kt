package lclang.methods

import lclang.*
import lclang.types.Type
import lclang.types.Types

class ClassMethod(val clazz: LCClass, private val methodContext: lclangParser.MethodContext):
    VisitorMethod(
        if(methodContext.type()!=null)
            Types.getType(methodContext.type())
        else Types.VOID,
        methodContext.args().arg(),
        {
            it.variables["this"] = Value({ clazz.classType }, { clazz })
            it.visitBlock(methodContext.block())
        }
    )