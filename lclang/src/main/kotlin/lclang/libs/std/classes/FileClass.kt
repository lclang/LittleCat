package lclang.libs.std.classes

import lclang.LCClass
import lclang.Value
import lclang.constructor
import lclang.libs.lang.ArrayClass
import lclang.libs.lang.BoolClass
import lclang.libs.lang.StringClass
import lclang.method
import lclang.types.Types
import java.io.File

const val FILE_CLASSNAME = "File"
class FileClass(): LCClass(FILE_CLASSNAME) {
    constructor(file: File) : this() {
        globals["name"] = StringClass(file.name).asValue()
        globals["path"] = StringClass(file.path).asValue()
        globals["absolutePath"] = StringClass(file.absolutePath).asValue()
        globals["canonicalPath"] = StringClass(file.canonicalPath).asValue()
        globals["exists"] = Value(Types.BOOL) { BoolClass(file.exists()) }
        globals["isDirectory"] = Value(Types.BOOL) { BoolClass(file.isDirectory) }
        globals["isFile"] = Value(Types.BOOL) { BoolClass(file.isFile) }
        globals["files"] = Value(Types.ARRAY) {
            ArrayClass(file.listFiles()?.map {
                FileClass(it)
            } ?: listOf())
        }

        globals["openInput"] = method (returnType = Types.MagicType(INPUT_CLASSNAME)) {
            InputClass(file.inputStream() )
        }
        globals["openOutput"] = method (returnType = Types.MagicType(OUTPUT_CLASSNAME)) {
            OutputClass(file.outputStream())
        }

        globals["createDir"] = method (returnType = Types.BOOL) { BoolClass(file.mkdir()) }
        globals["createDirs"] = method (returnType = Types.BOOL) { BoolClass(file.mkdirs()) }
        globals["create"] = method (returnType = Types.BOOL) { BoolClass(file.createNewFile()) }
    }

    init {
        constructor = constructor(listOf(Types.STRING)) {
            FileClass(File(it[0].toString()))
        }
    }
}