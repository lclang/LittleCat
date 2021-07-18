package lclang

class Type(
    val name: String
){
    companion object {
        fun from(ctx: lclangParser.TypeContext): Type {
            var stringName = ctx.ID().text
            for(type in ctx.type())
                stringName += "\\"+type.ID().text

            return Type(stringName)
        }
    }
}