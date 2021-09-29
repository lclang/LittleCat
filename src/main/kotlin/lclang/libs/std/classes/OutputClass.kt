package lclang.libs.std.classes

import lclang.LCClass
import lclang.Value
import lclang.constructor
import lclang.lang.ArrayClass
import lclang.method
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.NamedType
import lclang.types.Types
import java.io.OutputStream
import java.io.PrintStream

const val OUTPUT_CLASSNAME = "Output"
class OutputClass(): LCClass(OUTPUT_CLASSNAME) {
    override var constructor: Method = constructor(listOf(CallableType(listOf(Types.INT))), classType) {
        val method = it[0] as Method
        OutputClass(object : OutputStream() {
            override fun write(b: Int) {
                method.call(this@constructor, listOf(Value(Types.INT, b)))
            }
        })
    }

    constructor(output: OutputStream) : this() {
        val printer = PrintStream(output)

        globals["println"] = method(listOf(Types.ANY)) { printer.println(it[0]) }
        globals["print"] = method(listOf(Types.ANY)) { printer.print(it[0]) }
        globals["printf"] = method(listOf(Types.ANY, Types.ARRAY)) { list -> printer.printf(list[0].toString(),
            * (list[1] as ArrayClass).list.map { it.get(this) }.toTypedArray())}
        globals["flush"] = method { printer.flush() }
        globals["close"] = method { printer.close() }
        globals["accept"] = method(listOf(NamedType(INPUT_CLASSNAME))) {
            val input = it[0] as InputClass
            while (input.scanner.hasNextLine())
                printer.println(input.scanner.nextLine())
        }
    }
}