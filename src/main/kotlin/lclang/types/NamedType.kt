package lclang.types

class NamedType(
    val name: String,
    val primitive: Boolean = false
): Type(name){
    override fun isAcceptWithoutNullable(another: Type): Boolean {
        return super.isAcceptWithoutNullable(another) ||
                another is NamedType &&
                another.primitive == primitive &&
                another.name == name
    }
}