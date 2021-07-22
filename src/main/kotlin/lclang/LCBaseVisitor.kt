package lclang

import lclang.exceptions.MethodNotFoundException
import lclang.lang.CharClass
import lclang.lang.StringClass
import lclang.methods.Method
import lclang.methods.VisitorMethod
import kotlin.math.pow

open class LCBaseVisitor : lclangBaseVisitor<Value?>() {
    var fileVisitor: LCFileVisitor? = null
    val methods = HashMap<String, Method>()

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
            visitStmt(stmt)?.let {
                if(it.isReturn||it.stop)
                    return@visitContainer it
                else it.get()
            }

        return Value({ Type.VOID }, { null })
    }

    override fun visitValue(ctx: lclangParser.ValueContext?): Value? {
        if(ctx==null) return null
        return when {
            ctx.STRING()!=null -> Value({ Type.STRING }, { StringClass(ctx.STRING().text.substring(1)
                .substringBeforeLast('"'), fileVisitor!!) })
            ctx.CHAR()!=null -> Value({ Type.CHAR }, { CharClass(ctx.CHAR().text.substring(1).substringBeforeLast('\'')[0], fileVisitor!!) })
            ctx.INTEGER()!=null -> Value({ Type.INT }, { ctx.INTEGER().text.toInt() })
            ctx.LONG()!=null -> Value({ Type.LONG }, { ctx.LONG().text
                .substringBeforeLast('L').toLong()})
            ctx.HEX_LONG()!=null -> Value({ Type.LONG }, { ctx.HEX_LONG().text
                .substring(1).toLong(radix=16)})
            ctx.BOOL()!=null -> Value({ Type.BOOL }, { ctx.BOOL().text=="true" })
            else -> throw Exception()
        }
    }

    override fun visitWhileStmt(ctx: lclangParser.WhileStmtContext?): Value? {
        while(visitExpression(ctx!!.condition)!!.apply {
                if(!Type.BOOL.isAccept(type()))
                    throw Exception("Value is not bool: "+type().name)
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
        val cond = visitExpression(ctx!!.condition)!!.apply {
            if(!Type.BOOL.isAccept(type()))
                throw Exception("Value is not bool: "+type().name)
        }

        if(cond.get()==true){
            return visitStmt(ctx.ifT)
        }

        return if(ctx.ifF!=null)
            visitStmt(ctx.ifF) else null
    }

    override fun visitStmt(ctx: lclangParser.StmtContext?): Value? {
        val value = visit(ctx!!.children[0])
        value?.get?.invoke()
        return value
    }

    override fun visitArray(ctx: lclangParser.ArrayContext?): Value? {
        return Value({ Type.ARRAY }, {
            val array = ValueList()
            for(expression in ctx!!.expression()){
                array.add(visitExpression(expression)!!)
            }

            return@Value array
        }, {
            val array = it!!.get()
            if(array !is List<*>) throw Exception("Is not list")

            for((i, expression) in ctx!!.expression().withIndex()){
                visitExpression(expression)!!.set(array[i] as Value)
            }
        })
    }

    override fun visitReturnExpr(ctx: lclangParser.ReturnExprContext?): Value? {
        return ctx?.expression()?.let { visitExpression(it) }?.apply {
            isReturn = true
        } ?: Value({ Type.VOID }, { null }, isReturn = true)
    }

    override fun visitStop(ctx: lclangParser.StopContext?): Value? {
        return Value({ Type.VOID }, { null }, stop = true)
    }

    override fun visitTypeGet(ctx: lclangParser.TypeGetContext?): Value? {
        return Value({ Type.STRING },
            {visitExpression(ctx!!.expression())!!.type().name})
    }

    override fun visitCall(ctx: lclangParser.CallContext?): Value? {
        if(ctx==null) return null

        val subjectName = Type.from(ctx.type()).name
        if(this !is LCClass&&fileVisitor?.classes?.containsKey(subjectName) == true){
            val clazz = fileVisitor!!.classes[subjectName]!!
            //TODO: args
            return Value({ Type(clazz.name) }, { clazz.create(listOf()) })
        }

        val notFoundException = MethodNotFoundException(subjectName,
            ctx.start.line, ctx.stop.line, fileVisitor?.path ?: "unknown")

        val method = methods[subjectName] ?: throw notFoundException
        if(method.args.size!=ctx.expression().size) throw notFoundException

        val args = ArrayList<Any?>()
        for(argNum in 0 until method.args.size){
            val value = visitExpression(ctx.expression(argNum)) ?: throw notFoundException
            if(!method.args[argNum].isAccept(value.type()))
                throw notFoundException

            args.add(value.get())
        }

        val value = method.call(fileVisitor!!, args)
        return Value({ method.returnType }, { value })
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Value? {
        when {
            ctx?.primitive()!=null -> return visitPrimitive(ctx.primitive())
            ctx?.expression()?.size==1 -> return visitExpression(ctx.expression(0))
            ctx!=null -> {
                val leftValue = visitExpression(ctx.expression(0))!!
                val leftType = leftValue.type()
                val left = leftValue.get()

                val rightValue = visitExpression(ctx.expression(0))!!
                val rightType = leftValue.type()
                val right = rightValue.get()

                if(left is Number&&right is Number) {
                    when {
                        ctx.div != null -> return Value(Type.DOUBLE, left.toDouble() / right.toDouble())
                        ctx.pow != null -> return Value(Type.DOUBLE, left.toDouble().pow(right.toDouble()))
                        ctx.less != null -> return Value(Type.BOOL, left.toDouble() < right.toDouble())
                        ctx.lessEquals != null -> return Value(Type.BOOL, left.toDouble() <= right.toDouble())
                        ctx.larger != null -> return Value(Type.BOOL, left.toDouble() > right.toDouble())
                        ctx.largerEquals != null -> return Value(Type.BOOL, left.toDouble() >= right.toDouble())

                        else -> {
                            val needType = when {
                                leftType==Type.DOUBLE||
                                        rightType==Type.DOUBLE -> Type.DOUBLE
                                leftType==Type.LONG||
                                        rightType==Type.LONG -> Type.LONG
                                else -> Type.INT
                            }

                            when {
                                ctx.multiplication != null -> return Value(needType, when(needType){
                                    Type.DOUBLE -> left.toDouble()*right.toDouble()
                                    Type.LONG -> left.toLong()*right.toLong()
                                    else -> left.toInt()*right.toInt()
                                })

                                ctx.add != null -> return Value(needType, when(needType){
                                    Type.DOUBLE -> left.toDouble()+right.toDouble()
                                    Type.LONG -> left.toLong()+right.toLong()
                                    else -> left.toInt()+right.toInt()
                                })

                                ctx.minus != null -> return Value(needType, when(needType){
                                    Type.DOUBLE -> left.toDouble()-right.toDouble()
                                    Type.LONG -> left.toLong()-right.toLong()
                                    else -> left.toInt()-right.toInt()
                                })
                            }
                        }
                    }
                }

                if(right is StringClass||left is StringClass){
                    when {
                        ctx.add!=null -> return Value(Type.STRING, right.toString()+left)
                        ctx.multiplication!=null&&
                            right is Int||left is Int ->
                                return Value(Type.STRING, if(right is Int)
                                    left.toString().repeat(right)
                                else right.toString().repeat(left as Int))
                    }
                }

                if(right is ValueList&&left is ValueList){
                    when {
                        ctx.add!=null -> return Value(Type.ARRAY, right+left)
                    }
                }

                if(right is Boolean&&left is Boolean){
                    when {
                        ctx.or!=null -> return Value(Type.BOOL, right||left)
                        ctx.and!=null -> return Value(Type.BOOL, right&&left)
                    }
                }

                return when {
                    /**Bool operations*/
                    ctx.equals!=null -> Value({ Type.BOOL }, { left == right })
                    ctx.notEquals!=null -> Value({ Type.BOOL }, { left != right })
                    else -> throw Exception()
                }
            }
            else -> throw Exception()
        }
    }

    override fun visitIfExpr(ctx: lclangParser.IfExprContext?): Value? {
        val cond = visitExpression(ctx!!.condition)!!.apply {
            if(!Type.BOOL.isAccept(type()))
                throw Exception("Value is not bool: "+type().name)
        }

        if(cond.get()==true){
            return visitExpression(ctx.ifT)
        }

        return visitExpression(ctx.ifF)
    }

    override fun visitMethod(ctx: lclangParser.MethodContext?): Value? {
        if(ctx==null) return null

        methods[ctx.ID().text] = VisitorMethod(ctx)
        return null
    }

    override fun visitPrimitive(ctx: lclangParser.PrimitiveContext?): Value? {
        var value = visit(ctx!!.children[0])!!
        for(access in ctx.arrayAccess()){
            val gettable = value.get()
            val orValue = value
            value = if(gettable is ValueList) {
                if(access.expression()!=null) {
                    val getValue = visitExpression(access.expression())!!
                    if (getValue.type().isAccept(Type.INT))
                        gettable[getValue.get() as Int]
                    else throw Exception("error name (array get type not int)")
                }else Value({ Type.ANY }, { gettable.last().get() }, {
                    gettable.add(it!!)
                    orValue.set(Value({Type.ARRAY}, {gettable}, orValue.set))
                })
            }else if(gettable is Map<*, *>){
                if(access.expression()==null) throw Exception("damn")

                val getValue = visitExpression(access.expression())!!
                gettable[getValue.get()] as Value
            }else throw Exception("error name (array get)")
        }

        if(ctx.operation()?.access()!=null){
            val classValue = value.get()
            if(classValue !is LCClass)
                throw Exception()

            value = classValue.visitExpression(ctx.operation().access().expression())!!
        }

        return value
    }
}