package lclang.methods

import lclang.Caller
import lclang.Value
import lclang.lang.CharClass
import lclang.lang.StringClass
import lclang.libs.std.classes.FileClass
import lclang.libs.std.classes.InputClass
import lclang.libs.std.classes.OutputClass
import lclang.types.Type
import java.io.File
import java.io.InputStream
import java.io.OutputStream

abstract class LibraryMethod(args: List<Type>, returnType: Type) : Method(args, returnType) {
    override fun call(caller: Caller, args: List<Value>): Any? {
        val value = callMethod(caller, args.map { it.get(caller) })
        if(value is Unit) return null

        return when(value) {
            is Char -> CharClass(value, caller.file)
            is String -> StringClass(value, caller.file)
            is File -> FileClass(value, caller.file)
            is InputStream -> InputClass(value, caller.file)
            is OutputStream -> OutputClass(value, caller.file)
            else -> value
        }
    }

    abstract fun callMethod(caller: Caller, args: List<Any?>): Any?
}