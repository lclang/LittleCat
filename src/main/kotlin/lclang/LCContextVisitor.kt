package lclang

open class LCContextVisitor: LCBaseVisitor() {
    val variables = HashMap<String, Any?>()
    init {
        variables["test"] = "test"
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Any? {
        val variableName = ctx!!.ID().text
        if(!variables.containsKey(variableName))
            throw Exception("Variable $variableName not found")

        return variables[variableName]
    }
}