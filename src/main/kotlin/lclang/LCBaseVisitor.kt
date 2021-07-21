package lclang

import lclang.lang.StringClass
import lclang.methods.Method
import lclang.methods.VisitorMethod

open class LCBaseVisitor : lclangBaseVisitor<Value?>() {
    var fileVisitor: LCFileVisitor? = null
    val methods = HashMap<String, Method>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Value? {
        for(stmt in ctx!!.stmt())
            visit(stmt)?.let {
                if(it.isReturn)
                    return@visitBlock it
                else it.get()
            }

        return null
    }

    override fun visitValue(ctx: lclangParser.ValueContext?): Value? {
        if(ctx==null) return null
        return when {
            ctx.STRING()!=null -> Value({ Type.STRING }, { StringClass(ctx.STRING().text.substring(1)
                .substringBeforeLast('"'), fileVisitor!!) })
            ctx.INTEGER()!=null -> Value({ Type.INT }, { ctx.INTEGER().text.toInt() })
            ctx.LONG()!=null -> Value({ Type.LONG }, { ctx.LONG().text
                .substringBeforeLast('L').toLong()})
            ctx.BOOL()!=null -> Value({ Type.BOOL }, { ctx.BOOL().text=="true" })
            else -> throw Exception()
        }
    }

    override fun visitWhileStmt(ctx: lclangParser.WhileStmtContext?): Value? {
        val cond = visitExpression(ctx!!.condition)!!.apply {
            if(!Type.BOOL.isAccept(type()))
                throw Exception("Value is not bool: "+type().name)
        }

        while(cond.get()==true){
            val value = visitStmt(ctx.stmt())
            if(value?.isReturn==true)
                return value
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

    override fun visitTypeGet(ctx: lclangParser.TypeGetContext?): Value? {
        return Value({ Type.STRING },
            {visitExpression(ctx!!.expression())!!.type().name})
    }

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Value? {
        when {
            ctx?.primitive()!=null -> return visitPrimitive(ctx.primitive())
            ctx?.expression()?.size==1 -> return visitExpression(ctx.expression(0))
            else -> if(ctx==null) return null
        }

        val left = visitExpression(ctx.expression(0))?.get?.let{ it() }
        val right = visitExpression(ctx.expression(1))?.get?.let{ it() }

        return when {
            ctx.multiplication!=null&&
                    left is Number&&
                    right is Number -> when {
                left is Double||right is Double -> Value({Type.DOUBLE}, {left.toDouble()*right.toDouble()})
                left is Long||right is Long -> Value({Type.LONG}, {left.toLong()*right.toLong()})
                left is Int||right is Int -> Value({Type.INT}, {left.toInt()*right.toInt()})
                else -> throw Exception()
            }
            ctx.div!=null&&
                    left is Number&&
                    right is Number -> Value({ Type.DOUBLE }, {left.toDouble()/right.toDouble()})
            ctx.add!=null -> {
                return if(left is Number&&
                    right is Number)
                    when {
                        left is Double||right is Double -> Value({Type.DOUBLE}, {left.toDouble()+right.toDouble()})
                        left is Long||right is Long -> Value({Type.LONG}, {left.toLong()+right.toLong()})
                        left is Int||right is Int -> Value({Type.INT}, {left.toInt()+right.toInt()})
                        else -> throw Exception()
                    }
                else Value({ Type.STRING }, { StringClass(left.toString()+right, fileVisitor!!) })
            }
            ctx.minus!=null&&
                    left is Number&&
                    right is Number -> when {
                left is Double||right is Double -> Value({Type.DOUBLE}, {left.toDouble()-right.toDouble()})
                left is Long||right is Long -> Value({Type.LONG}, {left.toLong()-right.toLong()})
                left is Int||right is Int -> Value({Type.INT}, {left.toInt()-right.toInt()})
                else -> throw Exception()
            }

            /**Bool operations*/
            ctx.equals!=null -> Value({ Type.BOOL }, { left == right })
            ctx.notEquals!=null -> Value({ Type.BOOL }, { left != right })
            ctx.or!=null&&
                    left is Boolean&&
                    right is Boolean -> Value({ Type.BOOL }, { left||right })
            ctx.and!=null&&
                    left is Boolean&&
                    right is Boolean -> Value({ Type.BOOL }, { left&&right })

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