package lclang.methods

import lclang.Caller
import lclang.LCRootExecutor
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

abstract class LibraryMethod(root: LCRootExecutor, args: List<Type>, returnType: Type) : Method(root, args, returnType) {
    override fun call(caller: Caller, args: List<Value>): Any? {
        val value = callMethod(caller, args.map {
            if(it !is Method) it.get(caller)
            else it
        })

        if(value is Unit) return null

        return when(value) {
            is Char -> CharClass(value)
            is String -> StringClass(value)
            is File -> FileClass(value)
            is InputStream -> InputClass(value)
            is OutputStream -> OutputClass(value)
            else -> value
        }
    }

    abstract fun callMethod(caller: Caller, args: List<Any?>): Any?
}