package lclang.libs.std.classes

import lclang.LCClass
import lclang.constructor
import lclang.libs.lang.*
import lclang.method
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Types
import lclang.void
import java.io.InputStream
import java.util.*

const val INPUT_CLASSNAME = "Input"
class InputClass(): LCClass(INPUT_CLASSNAME) {
    lateinit var scanner: Scanner

    constructor(input: InputStream) : this() {
        scanner = Scanner(input)

        globals["hasNextLine"] = method(returnType = Types.BOOL) { BoolClass(scanner.hasNextLine()) }
        globals["hasNextInt"] = method(returnType = Types.BOOL) { BoolClass(scanner.hasNextInt()) }
        globals["hasNextLong"] = method(returnType = Types.BOOL) { BoolClass(scanner.hasNextLong()) }
        globals["hasNextDouble"] = method(returnType = Types.BOOL) { BoolClass(scanner.hasNextDouble()) }
        globals["hasNext"] = method(returnType = Types.BOOL) { BoolClass(scanner.hasNext()) }

        globals["readLine"] = method(returnType = Types.STRING) { StringClass(scanner.nextLine()) }
        globals["readInt"] = method(returnType = Types.INT) { IntClass(scanner.nextInt()) }
        globals["readLong"] = method(returnType = Types.LONG) { LongClass(scanner.nextLong()) }
        globals["readDouble"] = method(returnType = Types.DOUBLE) { DoubleClass(scanner.nextDouble()) }
        globals["read"] = method(returnType = Types.STRING) { StringClass(scanner.next()) }
        globals["close"] = void { scanner.close() }
    }

    init {
        constructor = constructor(listOf(CallableType(arrayOf(), Types.INT))) {
            val method = it[0] as Method
            InputClass(object : InputStream() {
                override fun read(): Int = (method.call(this@constructor, listOf()) as IntClass).int
            })
        }
    }
}