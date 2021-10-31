package lclang.types

import lclang.LCClass

open class NamedType(
    val clazz: LCClass,
): Type(clazz.name) {
    override fun isAcceptWithoutNullable(another: Type): Boolean {
        return super.isAcceptWithoutNullable(another) ||
                        another is Types.MagicType &&
                        another.text == clazz.name ||
                another is NamedType &&
                another.clazz.canCast(clazz)
    }
}