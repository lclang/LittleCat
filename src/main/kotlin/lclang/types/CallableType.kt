package lclang.types

import lclang.isAccept
import lclang.lclangParser

class CallableType(
    val args: List<BaseType>,
    val returnType: BaseType
): BaseType("callable") {

    override fun isAccept(another: BaseType): Boolean {
        if(another == Types.ANY) return true
        if(another == Types.CALLABLE) return true
        if(another !is CallableType) return false

        return args.isAccept(another.args)==-1&&returnType.isAccept(another.returnType)
    }

    companion object {
        fun from(ctx: lclangParser.MethodTypeContext): CallableType {
            val args = ArrayList<BaseType>()
            for(argType in ctx.type())
                args.add(Types.getType(argType))

            return CallableType(args, Types.getType(ctx.returnType))
        }
    }
}