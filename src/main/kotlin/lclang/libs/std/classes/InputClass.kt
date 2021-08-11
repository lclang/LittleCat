package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.method
import lclang.types.Types
import java.io.InputStream
import java.util.*

class InputClass(input: InputStream, fileVisitor: LCFileVisitor): LCClass("Input", fileVisitor) {
    private val scanner = Scanner(input)

    init {
        globals["readLine"] = method(returnType = Types.STRING) { _, _ -> scanner.nextLine() }
        globals["readInt"] = method(returnType = Types.INT) { _, _ -> scanner.nextInt() }
        globals["readLong"] = method(returnType = Types.LONG) { _, _ -> scanner.nextLong() }
        globals["readDouble"] = method(returnType = Types.DOUBLE) { _, _ -> scanner.nextDouble() }
        globals["read"] = method(returnType = Types.STRING) { _, _ -> scanner.next() }
        globals["close"] = method { _, _ -> scanner.close() }
    }
}