package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.lang.StringClass
import lclang.method
import lclang.types.Types
import java.io.InputStream
import java.util.*

class InputClass(fileVisitor: LCFileVisitor): LCClass("Input", fileVisitor) {
    constructor(input: InputStream, fileVisitor: LCFileVisitor) : this(fileVisitor) {
        val scanner = Scanner(input)

        globals["hasNextLine"] = method(returnType = Types.BOOL) { _, _ -> scanner.hasNextLine() }
        globals["hasNextInt"] = method(returnType = Types.BOOL) { _, _ -> scanner.hasNextInt() }
        globals["hasNextLong"] = method(returnType = Types.BOOL) { _, _ -> scanner.hasNextLong() }
        globals["hasNextDouble"] = method(returnType = Types.BOOL) { _, _ -> scanner.hasNextDouble() }
        globals["hasNext"] = method(returnType = Types.BOOL) { _, _ -> scanner.hasNext() }

        globals["readLine"] = method(returnType = Types.STRING) { _, _ -> StringClass(scanner.nextLine(), fileVisitor) }
        globals["readInt"] = method(returnType = Types.INT) { _, _ -> scanner.nextInt() }
        globals["readLong"] = method(returnType = Types.LONG) { _, _ -> scanner.nextLong() }
        globals["readDouble"] = method(returnType = Types.DOUBLE) { _, _ -> scanner.nextDouble() }
        globals["read"] = method(returnType = Types.STRING) { _, _ -> StringClass(scanner.next(), fileVisitor) }
        globals["close"] = method { _, _ -> scanner.close() }
    }
}