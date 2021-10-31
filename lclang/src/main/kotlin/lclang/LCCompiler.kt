package lclang

import lclang.libs.lang.*
import lclang.methods.MethodImpl
import lclang.statements.*
import lclang.types.Types

class LCCompiler: lclangBaseVisitor<Statement>() {
    override fun visitStmt(ctx: lclangParser.StmtContext): Statement = visit(ctx.children[0])
    override fun visitVariable(ctx: lclangParser.VariableContext) = VariableExpression(ctx.ID().text, ctx.start.line, ctx.stop.line)
    override fun visitBlock(ctx: lclangParser.BlockContext): Statement =
        BlockStatement(ctx.stmt().map { visitStmt(it) }.toTypedArray(), ctx.start.line, ctx.stop.line)
    override fun visitContainer(ctx: lclangParser.ContainerContext): Expression =
        ContainerExpression(ctx.stmt().map { visitStmt(it) }.toTypedArray(), ctx.start.line, ctx.stop.line)

    override fun visitValue(ctx: lclangParser.ValueContext): ValueExpression {
        val text = ctx.text
        return ValueExpression(when {
            ctx.STRING()!=null -> StringClass(
                unescapeString(text.substring(1).substringBeforeLast('"'))).asValue()
            ctx.CHAR()!=null -> CharClass(unescapeString(text)[1]).asValue()
            ctx.DOUBLE()!=null -> DoubleClass(text.toDouble()).asValue()
            ctx.INTEGER()!=null -> IntClass(text.toInt()).asValue()
            ctx.LONG()!=null -> LongClass(text.substringBeforeLast('L').toLong()).asValue()
            ctx.HEX_LONG()!=null -> LongClass(text.substring(1).toLong(radix=16)).asValue()
            ctx.BOOL()!=null -> BoolClass(text.startsWith('t')).asValue()
            ctx.NULL()!=null -> Value(Types.UNDEFINED, null)

            else -> throw Exception("Invalid value $text")
//            else -> throw LCLangException("Syntax error", "Invalid value $text", ctx.asCaller(this))
        }, ctx.start.line, ctx.stop.line)
    }

    override fun visitClassExpr(ctx: lclangParser.ClassExprContext): Statement {
        return ClassStatement(ctx.name.text, ctx.classExtends.text, ctx.start.line, ctx.stop.line)
    }

//    override fun visitMethod(ctx: lclangParser.MethodContext): Statement {
//        return MethodStatement(ctx.ID().text, ctx.args().arg().map {
//            it.ID().text to Types.getType(it.type())
//        }.toMap())
//    }

    override fun visitWhileStmt(ctx: lclangParser.WhileStmtContext): Statement {
        return WhileStatement(visitExpression(ctx.expression()), ctx.stmt()?.let { visitStmt(it) },
            ctx.start.line, ctx.stop.line)
    }

    override fun visitIfStmt(ctx: lclangParser.IfStmtContext): Statement = IfStatement(
        visitExpression(ctx.condition),
        visitStmt(ctx.ifT),
        ctx.ifF?.let { visitStmt(it) },
        ctx.start.line, ctx.stop.line)

    override fun visitIfExpr(ctx: lclangParser.IfExprContext): Expression = IfExpression(
        visitExpression(ctx.condition),
        visitExpression(ctx.ifT),
        visitExpression(ctx.ifF),
        ctx.start.line, ctx.stop.line)

    override fun visitArray(ctx: lclangParser.ArrayContext): Expression = ArrayExpression(
        ctx.expression().map { visitExpression(it) }, ctx.start.line, ctx.stop.line)

    override fun visitLambda(ctx: lclangParser.LambdaContext): Statement {
        return LambdaExpression(ctx.arg().toTypedArray(),
            ctx.type(), visitExpression(ctx.expression()), ctx.start.line, ctx.stop.line)
    }

    override fun visitReturnExpr(ctx: lclangParser.ReturnExprContext): Expression =
        ReturnExpression(ctx.expression()?.let { visitExpression(it) }, ctx.start.line, ctx.stop.line)

    override fun visitTypeGet(ctx: lclangParser.TypeGetContext): Expression =
        GetTypeExpression(visitExpression(ctx.expression()), ctx.start.line, ctx.stop.line)

    override fun visitNewClass(ctx: lclangParser.NewClassContext): Expression =
        GetClassConstructorExpression(ctx.className.text, ctx.start.line, ctx.stop.line)

    override fun visitExpression(ctx: lclangParser.ExpressionContext): Expression =
        ctx.primitive()?.let { visitPrimitive(it) } ?:
        kotlin.run {
            val expressions = ctx.expression().map { visitExpression(it) }
            if(ctx.call!=null){
                val arguments = expressions.toMutableList()
                arguments.removeAt(0)

                CallExpression(expressions[0], arguments.toTypedArray(), ctx.call.line, ctx.call.line)
            }else if(ctx.access!=null){
                AccessExpression(expressions[0], visitVariable(ctx.variable()), ctx.start.line, ctx.stop.line)
            }else if(expressions.size==1){
                UnaryOperationExpression(expressions[0],
                    when {
                        ctx.unaryPlus!=null -> UnaryOperationExpression.Operation.UNARY_PLUS
                        ctx.unaryMinus!=null -> UnaryOperationExpression.Operation.UNARY_MINUS
                        ctx.not!=null -> UnaryOperationExpression.Operation.NOT
                        ctx.throwNull!=null -> UnaryOperationExpression.Operation.NULL_CHECK
                        else -> throw Exception("fe "+ctx.text)
                    }, ctx.start.line, ctx.stop.line)
            }else{
                val binaryOperation = when {
                    ctx.`is`!=null -> BinaryOperationExpression.Operation.IS
                    ctx.add!=null -> BinaryOperationExpression.Operation.ADD
                    ctx.minus!=null -> BinaryOperationExpression.Operation.MINUS
                    ctx.multiplication!=null -> BinaryOperationExpression.Operation.MULTIPLICATION
                    ctx.div!=null -> BinaryOperationExpression.Operation.DIVISION
                    ctx.pow!=null -> BinaryOperationExpression.Operation.POW
                    ctx.largerEquals!=null -> BinaryOperationExpression.Operation.LARGER_EQUALS
                    ctx.larger!=null -> BinaryOperationExpression.Operation.LARGER
                    ctx.less!=null -> BinaryOperationExpression.Operation.LESS
                    ctx.lessEquals!=null -> BinaryOperationExpression.Operation.LESS_EQUALS
                    ctx.equals!=null -> BinaryOperationExpression.Operation.EQUALS
                    ctx.notEquals!=null -> BinaryOperationExpression.Operation.NOT_EQUALS
                    ctx.or!=null -> BinaryOperationExpression.Operation.OR
                    ctx.and!=null -> BinaryOperationExpression.Operation.AND
                    ctx.arrayAccess!=null -> BinaryOperationExpression.Operation.ARRAY_ACCESS
                    ctx.nullableOr!=null -> BinaryOperationExpression.Operation.NULLABLE_OR
                    else -> null
                }

                if(ctx.assign!=null) {
                    var setExpression = expressions[1]
                    if(binaryOperation!=null)
                        setExpression = BinaryOperationExpression(expressions[0],
                            setExpression, binaryOperation, ctx.start.line, ctx.stop.line)

                    AssignExpression(expressions[0], setExpression, ctx.start.line, ctx.stop.line)
                } else BinaryOperationExpression(expressions[0], expressions[1], binaryOperation ?:
                        throw Exception("fe"), ctx.start.line, ctx.stop.line)
            }
        }

    fun fillFile(root: LCRootExecutor, ctx: lclangParser.FileContext) {
        val libraries = Global.libraries+Global.javaLibraries
        for(library in libraries) root.accept(library)

        root.statements.clear()
        root.statements.addAll(ctx.stmt().map { visitStmt(it) })
        root.globals.putAll(ctx.global().associate {
            it.ID().text to visitValue(it.value()).value
        })

        root.globals.putAll(ctx.method().associate { methodContext ->
            methodContext.ID().text to MethodImpl(root.executor, methodContext.arg().associate {
                it.ID().text to Types.getType(root, it.type())
            }, methodContext.returnType?.let { it -> Types.getType(root, it) }?: Types.VOID,
                visit(methodContext.block()?: methodContext.expression())).asValue()
        })
    }


    override fun visitStop(ctx: lclangParser.StopContext): Expression = StopExpression(ctx.start.line, ctx.stop.line)
    override fun visitPrimitive(ctx: lclangParser.PrimitiveContext): Expression = visit(ctx.children[0]) as Expression
}