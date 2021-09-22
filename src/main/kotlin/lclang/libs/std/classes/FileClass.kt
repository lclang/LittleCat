package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.Value
import lclang.lang.ArrayClass
import lclang.lang.StringClass
import lclang.method
import lclang.types.NamedType
import lclang.types.Types
import java.io.File

const val FILE_CLASSNAME = "File"
class FileClass(fileVisitor: LCFileVisitor): LCClass(FILE_CLASSNAME, fileVisitor) {
    constructor(file: File, fileVisitor: LCFileVisitor) : this(fileVisitor) {
        globals["name"] = StringClass(file.name, fileVisitor).asValue()
        globals["path"] = StringClass(file.path, fileVisitor).asValue()
        globals["absolutePath"] = StringClass(file.absolutePath, fileVisitor).asValue()
        globals["canonicalPath"] = StringClass(file.canonicalPath, fileVisitor).asValue()
        globals["files"] = Value(Types.ARRAY) {
            ArrayClass(fileVisitor).apply {
                file.listFiles()?.forEach {
                    add(FileClass(it, fileVisitor).asValue())
                }
            }
        }

        globals["openInput"] = method (returnType = NamedType(INPUT_CLASSNAME)) { file.inputStream() }
        globals["openOutput"] = method (returnType = NamedType(OUTPUT_CLASSNAME)) { file.outputStream() }
    }
}