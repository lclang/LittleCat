package lclang.libs.std

import lclang.ERROR_COLOR
import lclang.Global
import lclang.exceptions.LCLangException
import lclang.lang.StringClass
import lclang.libs.Library
import lclang.libs.std.classes.*
import lclang.method
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.NamedType
import lclang.types.Types
import java.io.File
import kotlin.system.exitProcess

class StdLibrary: Library("std") {

    init {
        globals["LC_VERSION"] = StringClass(Global.version, this).asValue()
        classes["Socket"] = SocketClass(this)

        globals["output"] = OutputClass(System.out, this).asValue()
        globals["math"] = MathClass(this).asValue()
        globals["input"] = InputClass(System.`in`,this).asValue()

        globals["thread"] = method(listOf(CallableType(listOf(), Types.VOID)), Types.VOID) {
            val method = it[0] as Method
            Thread {
                method.call(this, listOf())
            }.start()
        }

        // DEPRECATED: NEED TRANSFER TO STREAMS.LCAT LIB
        globals["printError"] = method(listOf(Types.ANY), Types.VOID) {
            println("$ERROR_COLOR${it[0]}")
        }

        globals["assert"] = method(listOf(Types.BOOL)) { args ->
            if(args[0]==false) throw LCLangException("Assertion Error", "Value is false", this)
        }

        globals["exit"] = method(listOf(Types.INT), Types.VOID) { exitProcess(it[0] as Int) }
        globals["openFile"] = method(listOf(Types.STRING), NamedType(FILE_CLASSNAME)) { File(it[0].toString()) }
        globals["time"] = method(listOf(), Types.LONG) { System.currentTimeMillis() / 1000 }
        globals["millisTime"] = method(listOf(), Types.LONG) { System.currentTimeMillis() }
        globals["sleep"] = method(listOf(Types.LONG), Types.VOID) {
            Thread.sleep(it[0] as Long)
        }
    }
}