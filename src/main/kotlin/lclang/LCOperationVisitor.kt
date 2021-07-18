package lclang

class LCOperationVisitor(left: Any?): LCBaseVisitor() {

    override fun visitOperation(ctx: lclangParser.OperationContext?): Any? {
        return visit(ctx!!.children[0])
    }

    override fun visitAccess(ctx: lclangParser.AccessContext?): Any? {
        return super.visitAccess(ctx)
    }
}