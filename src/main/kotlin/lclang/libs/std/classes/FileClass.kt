package lclang.libs.std.classes

import lclang.LCClass
import lclang.Value
import lclang.constructor
import lclang.lang.ArrayClass
import lclang.lang.StringClass
import lclang.method
import lclang.methods.Method
import lclang.types.NamedType
import lclang.types.Types
import java.io.File

const val FILE_CLASSNAME = "File"
class FileClass(): LCClass(FILE_CLASSNAME) {
    override var constructor: Method = constructor(listOf(Types.STRING), classType) {
        FileClass(File(it[0].toString()))
    }

    constructor(file: File) : this() {
        globals["name"] = StringClass(file.name).asValue()
        globals["path"] = StringClass(file.path).asValue()
        globals["absolutePath"] = StringClass(file.absolutePath).asValue()
        globals["canonicalPath"] = StringClass(file.canonicalPath).asValue()
        globals["exists"] = Value(Types.BOOL) { file.exists() }
        globals["isDirectory"] = Value(Types.BOOL) { file.isDirectory }
        globals["isFile"] = Value(Types.BOOL) { file.isFile }
        globals["files"] = Value(Types.ARRAY) {
            ArrayClass().apply {
                file.listFiles()?.forEach {
                    add(FileClass(it).asValue())
                }
            }
        }

        globals["openInput"] = method (returnType = NamedType(INPUT_CLASSNAME)) { file.inputStream() }
        globals["openOutput"] = method (returnType = NamedType(OUTPUT_CLASSNAME)) { file.outputStream() }

        globals["createDir"] = method (returnType = Types.BOOL) { file.mkdir() }
        globals["createDirs"] = method (returnType = Types.BOOL) { file.mkdirs() }
        globals["create"] = method (returnType = Types.BOOL) { file.createNewFile() }
    }
}