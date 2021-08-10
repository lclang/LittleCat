package lclang

import lclang.exceptions.LCLangException
import lclang.exceptions.MethodNotFoundException
import lclang.exceptions.TypeErrorException
import lclang.exceptions.VariableNotFoundException
import lclang.lang.CharClass
import lclang.lang.StringClass
import lclang.methods.LambdaMethod
import lclang.methods.Method
import lclang.types.BaseType
import lclang.types.CallableType
import lclang.types.Types
import kotlin.math.pow

open class LCBaseVisitor(
    parent: LCBaseVisitor? = null, importVars: Boolean = false): lclangBaseVisitor<Value?>() {
    lateinit var fileVisitor: LCFileVisitor
    val globals = HashMap<String, Value?>()
    val variables = HashMap<String, Value?>()

    init {
        if(parent!=null) {
            if(importVars) variables.putAll(parent.variables)
            globals.putAll(parent.globals)
            fileVisitor = parent.fileVisitor
        }
    }

    override fun visitVariable(ctx: lclangParser.VariableContext?): Value {
        val variableName = ctx!!.ID().text

        return (variables[variableName] ?: globals[variableName] ?:
            Value({ Types.UNDEFINED }, {
                throw VariableNotFoundException(variableName,
                    ctx.start.line, ctx.stop.line, fileVisitor.path
                )
            })).apply { set = { variables[variableName] = it } }
    }

    override fun visitBlock(ctx: lclangParser.BlockContext?): Value? {
        for(stmt in ctx!!.stmt())
            visit(stmt)?.let {
                if(it.isReturn||it.stop)
                    return@visitBlock it
                else it.get()
            }

        return null
    }

    override fun visitContainer(ctx: lclangParser.ContainerContext?): Value? {
        for(stmt in ctx!!.stmt())
            visit(stmt)?.let {
                if(it.isReturn||it.stop)
                    return@visitContainer it
                else it.get()
            }

        return Value({ Types.VOID }, { null })
    }

    override fun visitValue(ctx: lclangParser.ValueContext?): Value? {
        if(ctx==null) return null
        return when {
            ctx.STRING()!=null -> Value(Types.STRING, StringClass(ctx.STRING().text.substring(1)
                .substringBeforeLast('"'), fileVisitor))
            ctx.CHAR()!=null -> Value(Types.CHAR, CharClass(ctx.CHAR().text.substring(1)
                .substringBeforeLast('\'')[0], fileVisitor))
            ctx.DOUBLE()!=null -> Value(Types.DOUBLE, ctx.DOUBLE().text.toDouble())
            ctx.INTEGER()!=null -> Value(Types.INT, ctx.INTEGER().text.toInt())
            ctx.LONG()!=null -> Value(Types.LONG, ctx.LONG().text
                .substringBeforeLast('L').toLong())
            ctx.HEX_LONG()!=null -> Value(Types.LONG, ctx.HEX_LONG().text
                .substring(1).toLong(radix=16))
            ctx.BOOL()!=null -> Value(Types.BOOL, ctx.BOOL().text=="true")
            ctx.NULL()!=null -> Value(Types.UNDEFINED, null)
            else -> throw LCLangException("Syntax error", "Invalid value "+ctx.text,
                ctx.start.line, ctx.stop.line, fileVisitor.path)
        }
    }

    override fun visitLambda(ctx: lclangParser.LambdaContext): Value = LambdaMethod(ctx)
    override fun visitWhileStmt(ctx: lclangParser.WhileStmtContext?): Value? {
        while(visitExpression(ctx!!.condition).apply {
                if(!Types.BOOL.isAccept(type()))
                    throw TypeErrorException("Value is not bool: "+type().text,
                        ctx.condition.start.line, ctx.condition.stop.line, fileVisitor.path)

            }.get()==true){
            val value = visitStmt(ctx.stmt())
            if(value?.isReturn==true)
                return value
            else if(value?.stop==true)
                break
        }

        return null
    }

    override fun visitIfStmt(ctx: lclangParser.IfStmtContext?): Value? {
        val cond = visitExpression(ctx!!.condition).apply {
            if(!Types.BOOL.isAccept(type()))
                throw TypeErrorException("Value is not bool: "+type().text,
                    ctx.condition.start.line, ctx.condition.stop.line, fileVisitor.path)
        }

        if(cond.get()==true){
            return visitStmt(ctx.ifT)
        }

        return if(ctx.ifF!=null)
            visitStmt(ctx.ifF) else null
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Value? {
        return visit(ctx!!.children[0])
    }

    override fun visitArray(ctx: lclangParser.ArrayContext?): Value? {
        return Value({ Types.ARRAY }, {
            val array = ValueList(fileVisitor)
            for(expression in ctx!!.expression()){
                array.add(visitExpression(expression))
            }

            return@Value array
        }, {
            val array = it!!.get()
            if(array !is ValueList)
                throw TypeErrorException("Value is not array", ctx!!.start.line, ctx.stop.line,
                    fileVisitor.path)

            for((i, expression) in ctx!!.expression().withIndex()){
                visitExpression(expression).set(array.get(i))
            }
        })
    }

    override fun visitReturnExpr(ctx: lclangParser.ReturnExprContext?): Value? {
        return ctx?.expression()?.let { visitExpression(it) }?.apply {
            isReturn = true
        } ?: Value({ Types.VOID }, { null }, isReturn = true)
    }

    override fun visitStop(ctx: lclangParser.StopContext?): Value? {
        return Value({ Types.VOID }, { null }, stop = true)
    }

    override fun visitTypeGet(ctx: lclangParser.TypeGetContext?): Value? {
        return Value({ Types.STRING },
            { visitExpression(ctx!!.expression()).type().text})
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Value {
        when {
            ctx?.primitive()!=null -> return visitPrimitive(ctx.primitive())
            ctx?.expression()?.size==1 -> return visitExpression(ctx.expression(0))
            ctx!=null -> {
                val leftValue = visitExpression(ctx.expression(0))
                val leftType = leftValue.type()
                val left = leftValue.get()

                val rightValue = visitExpression(ctx.expression(1))
                val rightType = rightValue.type()
                val right = rightValue.get()

                if(left is Number&&right is Number) {
                    when {
                        ctx.div != null -> return Value(Types.DOUBLE, left.toDouble() / right.toDouble())
                        ctx.pow != null -> return Value(Types.DOUBLE, left.toDouble().pow(right.toDouble()))
                        ctx.less != null -> return Value(Types.BOOL, left.toDouble() < right.toDouble())
                        ctx.lessEquals != null -> return Value(Types.BOOL, left.toDouble() <= right.toDouble())
                        ctx.larger != null -> return Value(Types.BOOL, left.toDouble() > right.toDouble())
                        ctx.largerEquals != null -> return Value(Types.BOOL, left.toDouble() >= right.toDouble())

                        else -> {
                            val needType = when {
                                leftType== Types.DOUBLE||
                                        rightType== Types.DOUBLE -> Types.DOUBLE
                                leftType== Types.LONG||
                                        rightType== Types.LONG -> Types.LONG
                                else -> Types.INT
                            }

                            when {
                                ctx.multiplication != null -> return Value(needType, when(needType){
                                    Types.DOUBLE -> left.toDouble()*right.toDouble()
                                    Types.LONG -> left.toLong()*right.toLong()
                                    else -> left.toInt()*right.toInt()
                                })

                                ctx.add != null -> return Value(needType, when(needType){
                                    Types.DOUBLE -> left.toDouble()+right.toDouble()
                                    Types.LONG -> left.toLong()+right.toLong()
                                    else -> left.toInt()+right.toInt()
                                })

                                ctx.minus != null -> return Value(needType, when(needType){
                                    Types.DOUBLE -> left.toDouble()-right.toDouble()
                                    Types.LONG -> left.toLong()-right.toLong()
                                    else -> left.toInt()-right.toInt()
                                })
                            }
                        }
                    }
                }

                if(left is StringClass||right is StringClass){
                    when {
                        ctx.add!=null -> return Value(Types.STRING, left.toString()+right)
                        ctx.multiplication!=null&&
                                right is Int||left is Int ->
                            return Value(
                                Types.STRING, StringClass(if(right is Int)
                                left.toString().repeat(right)
                            else right.toString().repeat(left as Int), fileVisitor))
                    }
                }

                if(right is ValueList&&left is ValueList){
                    when {
                        ctx.add!=null -> return Value(Types.ARRAY, left+right)
                    }
                }

                if(right is Boolean&&left is Boolean){
                    when {
                        ctx.or!=null -> return Value(Types.BOOL,left||right)
                        ctx.and!=null -> return Value(Types.BOOL, left&&right)
                    }
                }

                return when {
                    ctx.equals!=null -> Value({ Types.BOOL }, { left == right })
                    ctx.notEquals!=null -> Value({ Types.BOOL }, { left != right })
                    else -> throw TypeErrorException("Unsupported operand types: $leftType " +
                            "${ctx.getChild(1)} $rightType",
                                ctx.start.line, ctx.stop.line, fileVisitor.path)
                }
            }
            else -> throw Exception()
        }
    }

    override fun visitIfExpr(ctx: lclangParser.IfExprContext): Value {
        val cond = visitExpression(ctx.condition).apply {
            if(!Types.BOOL.isAccept(type()))
                throw TypeErrorException("Value is not bool: ${type()}",
                ctx.condition.start.line, ctx.condition.stop.line, fileVisitor.path)
        }

        if(cond.get()!=false){
            return visitExpression(ctx.ifT)
        }

        return visitExpression(ctx.ifF)
    }

    override fun visitNewClass(ctx: lclangParser.NewClassContext): Value {
        fileVisitor.classes[ctx.className.text]?.apply {
            return this.constructor
        }

        throw MethodNotFoundException("class ${ctx.className.text}",
            ctx.start.line, ctx.start.line, fileVisitor.path)
    }

    override fun visitParentnesesExpr(ctx: lclangParser.ParentnesesExprContext): Value {
        return visitExpression(ctx.expression())
    }

    override fun visitPrimitive(ctx: lclangParser.PrimitiveContext): Value {
        var value = visit(ctx.children[0])!!
        for(access in ctx.arrayAccess()){
            val gettable = value.get()
            val orValue = value
            value = if(gettable is ValueList) {
                if(access.expression()!=null) {
                    val getValue = visitExpression(access.expression())
                    if (getValue.type().isAccept(Types.INT))
                        gettable.get(getValue.get() as Int)
                    else throw TypeErrorException("invalid index: excepted int",
                        access.start.line, access.stop.line, fileVisitor.path)
                }else Value({ Types.ANY }, { gettable.last().get() }, {
                    gettable.add(it!!)
                    orValue.set(Value({ Types.ARRAY}, {gettable}, orValue.set))
                })
            }else if(gettable is Map<*, *>){
                if(access.expression()==null) throw TypeErrorException(
                    "invalid index: map not can add and set value",
                    access.start.line, access.stop.line, fileVisitor.path)

                val getValue = visitExpression(access.expression())
                gettable[getValue.get()] as Value
            }else throw TypeErrorException("excepted array or map", access.start.line, access.stop.line,
                    fileVisitor.path)
        }

        for(access in ctx.access()){
            val classValue = value.get()
            if(classValue !is LCClass)
                throw TypeErrorException("excepted class",
                    access.start.line, access.stop.line, fileVisitor.path)

            value = classValue.visitVariable(access.variable())
        }

        if(ctx.call !=null){
            if(value.type() !is CallableType)
                throw TypeErrorException("Value is not callable (it is ${value.type()})",
                    ctx.start.line, ctx.stop.line, fileVisitor.path)

            val argsTypes = ArrayList<BaseType>()
            val args = ArrayList<Value>()
            for(arg in ctx.expression())
                args.add(visitExpression(arg).let {
                    argsTypes.add(it.type())
                    it
                })

            val method = value as Method
            if(method.args.size!=argsTypes.size){
                if(method.args.size>argsTypes.size)
                    throw TypeErrorException("Invalid arguments: few arguments",
                        ctx.start.line, ctx.stop.line, fileVisitor.path)
                else throw TypeErrorException("Invalid arguments: too many arguments",
                    ctx.start.line, ctx.stop.line, fileVisitor.path)
            }

            val notAcceptArg = method.args.isAccept(argsTypes)
            if(notAcceptArg!=-1)
                throw TypeErrorException("Invalid argument $notAcceptArg",
                    ctx.expression(notAcceptArg).start.line, ctx.expression(notAcceptArg).stop.line,
                    fileVisitor.path)

            return Value(method.returnType, method.call(fileVisitor, args))
        }

        ctx.operation()?.assign()?.let { assign ->
            visitExpression(assign.expression()).let {
                value.set(it)
                return it
            }
        }

        return value
    }
}