package lclang

import lclang.methods.Method

open class LCBaseVisitor: lclangBaseVisitor<Value?>() {
    val methods = HashMap<String, Method>()

    override fun visitBlock(ctx: lclangParser.BlockContext?): Value? {
        for(stmt in ctx!!.stmt())
            visit(stmt)?.let { it.get() }

        return null
    }

    override fun visitTypeGet(ctx: lclangParser.TypeGetContext?): Value? {
        val type = visitExpression(ctx!!.expression())!!.type()
        return Value({ Type.STRING }, { type.name })
    }

    override fun visitValue(ctx: lclangParser.ValueContext?): Value? {
        if(ctx==null) return null
        return when {
            ctx.STRING()!=null -> Value({ Type.STRING }, { ctx.STRING().text.substring(1)
                .substringBeforeLast('"')})
            ctx.INTEGER()!=null -> Value({ Type.INT }, { ctx.INTEGER().text.toInt() })
            ctx.LONG()!=null -> Value({ Type.LONG }, { ctx.LONG().text
                .substringBeforeLast('L').toLong()})
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

    override fun visitExpression(ctx: lclangParser.ExpressionContext?): Value? {
        var value = visit(ctx!!.children[0])!!
        for(access in ctx.arrayAccess()){
            val gettable = value.get()
            value = if(gettable is ValueList) {
                if(access.expression()!=null) {
                    val getValue = visitExpression(access.expression())!!
                    if (getValue.type().isAccept(Type.INT))
                        gettable[getValue.get() as Int]
                    else throw Exception("error name (array get type not int)")
                }else Value({ Type.ANY }, { gettable.last() }, {
                    gettable.add(it!!)
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