package lclang.types

import lclang.isAccept
import lclang.lclangParser

class CallableType(
    val args: List<BaseType>,
    val returnType: BaseType
): BaseType(run {
    return@run "("+ args.joinToString(",") { it.toString() } +") -> " + returnType.toString()
}) {

    override fun isAcceptWithoutNullable(another: BaseType): Boolean {
        if(another == Types.CALLABLE) return true

        return super.isAcceptWithoutNullable(another) ||
                another is CallableType &&
                args.isAccept(another.args)==-1 &&
                returnType.isAccept(another.returnType)
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