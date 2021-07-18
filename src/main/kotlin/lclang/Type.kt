package lclang

class Type(
    val name: String
){
    companion object {
        val VOID = Type("void")

        fun from(ctx: lclangParser.TypeContext): Type {
            var stringName = ctx.ID().text
            for(type in ctx.type())
                stringName += "\\"+type.ID().text

            return when(stringName){
                "void" -> VOID
                else -> Type(stringName)
            }
        }
    }
}