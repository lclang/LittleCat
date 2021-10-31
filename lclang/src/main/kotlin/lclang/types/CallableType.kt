package lclang.types

import lclang.isAccept

class CallableType(
    val args: Array<out Type> = arrayOf(),
    val returnType: Type = Types.VOID
): Type("("+ args.joinToString(", ") { it.toString() } +") -> " + returnType.toString()) {

    override fun isAcceptWithoutNullable(another: Type): Boolean {
        if(another == Types.CALLABLE) return true

        return super.isAcceptWithoutNullable(another) ||
                another is CallableType &&
                args.isAccept(another.args)==-1 &&
                returnType.isAccept(another.returnType)
    }
}