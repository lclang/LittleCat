package lclang.libs.std.classes

import lclang.LCClass
import lclang.Value
import lclang.constructor
import lclang.libs.lang.classes.ArrayClass
import lclang.libs.lang.classes.BoolClass
import lclang.libs.lang.classes.StringClass
import lclang.method
import java.io.File

const val FILE_CLASSNAME = "File"
class FileClass(): LCClass(FILE_CLASSNAME) {
    constructor(file: File) : this() {
        globals["name"] = StringClass.get(file.name).asValue()
        globals["path"] = StringClass.get(file.path).asValue()
        globals["absolutePath"] = StringClass.get(file.absolutePath).asValue()
        globals["canonicalPath"] = StringClass.get(file.canonicalPath).asValue()
        globals["exists"] = Value(BoolClass.type) { BoolClass.get(file.exists()) }
        globals["isDirectory"] = Value(BoolClass.type) { BoolClass.get(file.isDirectory) }
        globals["isFile"] = Value(BoolClass.type) { BoolClass.get(file.isFile) }
        globals["files"] = Value(ArrayClass.type) {
            ArrayClass(file.listFiles()?.map {
                FileClass(it)
            } ?: listOf())
        }

        globals["openInput"] = method (returnType = InputClass.type) {
            InputClass(file.inputStream())
        }

        globals["openOutput"] = method (returnType = OutputClass.type) {
            OutputClass(file.outputStream())
        }

        globals["createDir"] = method (returnType = BoolClass.type) { BoolClass.get(file.mkdir()) }
        globals["createDirs"] = method (returnType = BoolClass.type) { BoolClass.get(file.mkdirs()) }
        globals["create"] = method (returnType = BoolClass.type) { BoolClass.get(file.createNewFile()) }
    }

    init {
        constructor = constructor(listOf(StringClass.type)) {
            FileClass(File(it[0].toString(this)))
        }
    }
}