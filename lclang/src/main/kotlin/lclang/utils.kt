package lclang

import lclang.libs.lang.*
import lclang.methods.Method
import lclang.types.NamedType
import lclang.types.Type
import lclang.types.Types
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

fun ParserRuleContext.asCaller(root: LCRootExecutor) = Caller(root, start.line, stop.line)
fun ParserRuleContext.asCaller(executor: LCBaseExecutor) = Caller(executor.root, start.line, stop.line)
fun Token.asCaller(root: LCRootExecutor) = Caller(root, line, line)
fun Token.asCaller(executor: LCBaseExecutor) = Caller(executor.root, line, line)

inline fun <reified T: Any> Any?.cast(): T = this as T
fun LCClass?.char(): CharClass = cast()
fun LCClass?.string(): StringClass = cast()
fun LCClass?.int(): IntClass = cast()
fun LCClass?.long(): LongClass = cast()
fun LCClass?.double(): DoubleClass = cast()
fun LCClass?.bool(): BoolClass = cast()
fun LCClass?.number(): Number = cast()

inline fun LCRootExecutor.method(args: List<Type> = listOf(), returnType: Type,
                               crossinline run: Caller.(List<LCClass?>) -> LCClass?): Value {
    return object: Method(this@method, args.toTypedArray(), returnType){
        override fun call(caller: Caller, args: List<Value>)= caller.run(args.map { it.get(caller) })
    }.asValue()
}

inline fun LCRootExecutor.void(vararg args: Type, crossinline run: Caller.(List<LCClass?>) -> Unit): Value {
    return object: Method(this@void, args, Types.VOID){
        override fun call(caller: Caller, args: List<Value>): LCClass? {
            caller.run(args.map { it.get(caller) })
            return null
        }
    }.asValue()
}

inline fun LCClass.constructor(args: List<Type> = listOf(),
                       crossinline run: Caller.(List<LCClass?>) -> LCClass?): Method {
    return object: Method(this@constructor, args.toTypedArray(), NamedType(this@constructor)){
        override fun call(caller: Caller, args: List<Value>)= caller.run(args.map { it.get(caller) })
    }
}

val unicodeEscapePattern = Regex("\\\\u([0-9A-f][0-9A-f][0-9A-f][0-9A-f])")
fun unescapeString(string: String): String {
    var output = string
        .replace("\\n", "\n")
        .replace("\\r", "\r")
        .replace("\\t", "\t")
        .replace("\\\"", "\"")

    while (true){
        val result = unicodeEscapePattern.find(output)?:break
        output = output.replace(result.value, result.groupValues[1].toLong(radix = 16).toInt().toChar().toString())
    }

    return output
}

val compiler = LCCompiler()

fun LCRootExecutor.runInput(input: String) {
    val lexer = lclangLexer(CharStreams.fromString(input))
    val parser = lclangParser(CommonTokenStream(lexer))
    parser.removeErrorListeners()
    parser.addErrorListener(ErrorListener(this))

    compiler.fillFile(this, parser.file())
    execute()
}

fun LCRootExecutor.runExpression(input: String): Value {
    val lexer = lclangLexer(CharStreams.fromString(input))
    val parser = lclangParser(CommonTokenStream(lexer))
    parser.removeErrorListeners()
    parser.addErrorListener(ErrorListener(this))

    val compiler = LCCompiler()
    return compiler.visitExpression(parser.expression())
        .visit(Caller(this, 0, 0), executor)
}