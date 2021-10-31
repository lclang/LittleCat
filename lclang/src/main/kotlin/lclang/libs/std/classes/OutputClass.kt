package lclang.libs.std.classes

import lclang.LCClass
import lclang.constructor
import lclang.libs.lang.ArrayClass
import lclang.libs.lang.IntClass
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Types
import lclang.void
import java.io.OutputStream
import java.io.PrintStream

const val OUTPUT_CLASSNAME = "Output"
class OutputClass(): LCClass(OUTPUT_CLASSNAME) {
    override var constructor: Method? = constructor(listOf(CallableType(arrayOf(Types.INT)))) {
        val method = it[0] as Method
        OutputClass(object : OutputStream() {
            override fun write(b: Int) {
                method.call(this@constructor, listOf(IntClass(b).asValue()))
            }
        })
    }

    constructor(output: OutputStream) : this() {
        val printer = PrintStream(output)

        globals["println"] = void(Types.ANY) { printer.println(it[0]) }
        globals["print"] = void(Types.ANY) { printer.print(it[0]) }
        globals["printf"] = void(Types.ANY, Types.ARRAY) { list -> printer.printf(list[0].toString(),
            * (list[1] as ArrayClass).list.map { it.get(this) }.toTypedArray())}
        globals["flush"] = void { printer.flush() }
        globals["close"] = void { printer.close() }
        globals["accept"] = void(Types.MagicType(INPUT_CLASSNAME)) {
            val input = it[0] as InputClass
            while (input.scanner.hasNextLine())
                printer.println(input.scanner.nextLine())
        }
    }
}