package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.method
import lclang.types.Types
import java.io.InputStream
import java.util.*

const val INPUT_CLASSNAME = "Input"
class InputClass(fileVisitor: LCFileVisitor): LCClass(INPUT_CLASSNAME, fileVisitor) {
    constructor(input: InputStream, fileVisitor: LCFileVisitor) : this(fileVisitor) {
        val scanner = Scanner(input)

        globals["hasNextLine"] = method(returnType = Types.BOOL) { scanner.hasNextLine() }
        globals["hasNextInt"] = method(returnType = Types.BOOL) { scanner.hasNextInt() }
        globals["hasNextLong"] = method(returnType = Types.BOOL) { scanner.hasNextLong() }
        globals["hasNextDouble"] = method(returnType = Types.BOOL) { scanner.hasNextDouble() }
        globals["hasNext"] = method(returnType = Types.BOOL) { scanner.hasNext() }

        globals["readLine"] = method(returnType = Types.STRING) { scanner.nextLine() }
        globals["readInt"] = method(returnType = Types.INT) { scanner.nextInt() }
        globals["readLong"] = method(returnType = Types.LONG) { scanner.nextLong() }
        globals["readDouble"] = method(returnType = Types.DOUBLE) { scanner.nextDouble() }
        globals["read"] = method(returnType = Types.STRING) { scanner.next() }
        globals["close"] = method { scanner.close() }
    }
}