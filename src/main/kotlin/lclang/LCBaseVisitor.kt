package lclang

import lclang.methods.Method

open class LCBaseVisitor: lclangBaseVisitor<Value?>() {
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
            ctx.STRING()!=null -> Value({ Type.STRING }, { ctx.STRING().text.substring(1)
                .substringBeforeLast('"')})
            ctx.INTEGER()!=null -> Value({ Type.INT }, { ctx.INTEGER().text.toInt() })
            ctx.LONG()!=null -> Value({ Type.LONG }, { ctx.LONG().text
                .substringBeforeLast('L').toLong()})
            ctx.BOOL()!=null -> Value({ Type.BOOL }, { ctx.BOOL().text=="true" })
            else -> throw Exception()
        }
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
            else -> if(ctx==null) return null
        }

        val left = visitExpression(ctx.expression(0))?.get?.let{ it() }
        val right = visitExpression(ctx.expression(1))?.get?.let{ it() }

        return when {
            ctx.multiplication!=null&&
                    left is Number&&
                    right is Number -> when {
                left is Long||right is Long -> Value({Type.LONG}, {left.toLong()*right.toLong()})
                left is Int||right is Int -> Value({Type.INT}, {left.toInt()*right.toInt()})
                else -> throw Exception()
            }
            ctx.add!=null&&
                    left is Number&&
                    right is Number -> when {
                left is Long||right is Long -> Value({Type.LONG}, {left.toLong()+right.toLong()})
                left is Int||right is Int -> Value({Type.INT}, {left.toInt()+right.toInt()})
                else -> throw Exception()
            }

            else -> throw Exception()
        }
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

        return value
    }
}