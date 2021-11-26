package lclang

import lclang.libs.lang.classes.BoolClass
import lclang.libs.lang.classes.CharClass
import lclang.libs.lang.classes.StringClass
import lclang.libs.lang.classes.numbers.DoubleClass
import lclang.libs.lang.classes.numbers.IntClass
import lclang.libs.lang.classes.numbers.LongClass
import lclang.methods.Method
import lclang.types.NamedType
import lclang.types.Type
import lclang.types.Types
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

inline fun <reified T: Any> Any?.cast(): T = this as T
fun LCClass?.char(): CharClass = cast()
fun LCClass?.string(): StringClass = cast()
fun LCClass?.int(): IntClass = cast()
fun LCClass?.long(): LongClass = cast()
fun LCClass?.double(): DoubleClass = cast()
fun LCClass?.bool(): BoolClass = cast()
fun LCClass?.number(): Number = cast()

inline fun LCRootExecutor.method(args: List<Type> = listOf(), returnType: Type,
                               crossinline run: Caller.(List<LCClass>) -> LCClass): Value {
    return object: Method(this@method, args, returnType){
        override fun call(caller: Caller, args: List<Value>) = caller.run(args.map { it.get(caller) }).asValue()
    }.asValue()
}

inline fun LCRootExecutor.void(vararg args: Type, crossinline run: Caller.(List<LCClass>) -> Unit): Value {
    return object: Method(this@void, args.asList(), Types.VOID){
        override fun call(caller: Caller, args: List<Value>): Value {
            caller.run(args.map { it.get(caller) })
            return Value.VOID
        }
    }.asValue()
}

inline fun LCClass.constructor(args: List<Type> = listOf(),
                       crossinline run: Caller.(List<LCClass>) -> LCClass): Method {
    return object: Method(this@constructor, args, NamedType(this@constructor)){
        override fun call(caller: Caller, args: List<Value>) = caller.run(args.map { it.get(caller) }).asValue()
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
        .visit(Caller(this,0), executor)
}