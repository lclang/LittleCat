package lclang.types

import lclang.isAccept

class CallableType(
    val args: List<Type>,
    val returnType: Type = Types.VOID
): Type(run {
    return@run "("+ args.joinToString(", ") { it.toString() } +") -> " + returnType.toString()
}) {

    override fun isAcceptWithoutNullable(another: Type): Boolean {
        if(another == Types.CALLABLE) return true

        return super.isAcceptWithoutNullable(another) ||
                another is CallableType &&
                args.isAccept(another.args)==-1 &&
                returnType.isAccept(another.returnType)
    }
}