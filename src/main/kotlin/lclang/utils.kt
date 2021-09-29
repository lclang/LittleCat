package lclang

import lclang.methods.LibraryMethod
import lclang.methods.Method
import lclang.types.Type
import lclang.types.Types
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun List<Type>.isAccept(array: List<Type>): Int {
    if(size!=array.size) return array.size-1
    for((i, type) in this.withIndex())
        if(!type.isAccept(array[i]))
            return i

    return -1
}

inline fun LCRootExecutor.method(args: List<Type> = listOf(), returnType: Type = Types.VOID,
                  crossinline run: Caller.(List<Any?>) -> Any?): Value {
    return object: LibraryMethod(this@method, args, returnType){
        override fun callMethod(caller: Caller, args: List<Any?>) = caller.run(args)
    }.asValue()
}

inline fun LCRootExecutor.constructor(args: List<Type> = listOf(), returnType: Type = Types.VOID,
                  crossinline run: Caller.(List<Any?>) -> Any?): Method {
    return object: LibraryMethod(this@constructor, args, returnType){
        override fun callMethod(caller: Caller, args: List<Any?>) = caller.run(args)
    }
}

inline fun LCClass.constructor(args: List<Type> = listOf(),
                       crossinline run: Caller.(List<Any?>) -> Any?): Method {
    return object: LibraryMethod(this@constructor, args, classType){
        override fun callMethod(caller: Caller, args: List<Any?>) = caller.run(args)
    }
}

fun LCRootExecutor.runInput(input: String) {
    val lexer = lclangLexer(CharStreams.fromString(input))
    val tokens = CommonTokenStream(lexer)
    val parser = lclangParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(ErrorListener(this))

    execute(parser.file())
}

fun LCRootExecutor.runExpression(input: String): Value {
    val lexer = lclangLexer(CharStreams.fromString(input))
    val tokens = CommonTokenStream(lexer)
    val parser = lclangParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(ErrorListener(this))

    return executor.visitExpression(parser.expression())
}