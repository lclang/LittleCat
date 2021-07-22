package lclang

class Type(
    val name: String,
    val primitive: Boolean = false
){
    fun isAccept(type: Type): Boolean {
        if(this == ANY) return true
        if(type.primitive&&primitive)
            return type.name == name

        return false
    }

    companion object {
        val VOID = Type("void", true)
        val ANY = Type("any", true)
        val INT = Type("int", true)
        val LONG = Type("long", true)
        val BOOL = Type("bool", true)
        val STRING = Type("string", true)
        val CHAR = Type("char", true)
        val ARRAY = Type("array", true)
        val DOUBLE = Type("double", true)

        fun from(ctx: lclangParser.TypeContext): Type {
            var stringName = ""
            for(type in ctx.ID())
                stringName += "\\"+type

            stringName = stringName.substring(1)

            return when(stringName){
                "void" -> VOID
                "any" -> ANY
                "int" -> INT
                "long" -> LONG
                "char" -> CHAR
                "string" -> STRING
                "array" -> ARRAY
                "bool" -> BOOL
                "double" -> DOUBLE
                else -> Type(stringName)
            }
        }
    }
}