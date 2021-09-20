package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.lang.StringClass
import lclang.libs.Library
import lclang.libs.std.classes.*
import lclang.methods.LibraryMethod
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Type
import lclang.types.Types
import java.io.File
import kotlin.system.exitProcess

class StdLibrary: Library("std") {

    init {
        globals["LC_VERSION"] = StringClass(Info.version, fileVisitor).asValue()

        classes["Socket"] = SocketClass(this)

        val output = OutputClass(System.out, this)
        globals["output"] = output.create()

        globals["math"] = MathClass(this).create()
        globals["input"] = InputClass(System.`in`,this).create()

        globals["require"] = method(listOf(Types.STRING), Types.ANY) {
            val requiredFile = File(File(fileVisitor.path).parent, it[0].toString())
            if(!requiredFile.exists())
                throw LCLangException("Require", "file "+it[0]+" not found", 0, 0,
                    fileVisitor.path)
            else if(requiredFile.length()==0L)
                return@method null

            val eval = LCFileVisitor(requiredFile.path.toString()).apply {
                libraries.addAll(fileVisitor.libraries)
                runInput(requiredFile.readText())
            }

            return@method eval.variables["export"]?.get?.let { it() }
        }

        globals["thread"] = method(listOf(CallableType(listOf(), Types.VOID)), Types.VOID) {
            val method = it[0] as Method
            Thread {
                method.call(this@StdLibrary, listOf())
            }.start()
        }

        // DEPRECATED: NEED TRANSFER TO STREAMS.LCAT LIB
        globals["printError"] = method(listOf(Types.ANY), Types.VOID) {
            println("$ERROR_COLOR${it[0]}")
        }

        globals["assert"] = method(listOf(Types.BOOL)) { args ->
            if(args[0]==false) throw LCLangException("Assertion Error", "Value is false", 0, 0, path)
        }

        globals["exit"] = method(listOf(Types.INT), Types.VOID) { exitProcess(it[0] as Int) }
        globals["openFile"] = method(listOf(Types.STRING), Type(FILE_CLASSNAME)) { File(it[0].toString()) }
        globals["time"] = method(listOf(), Types.LONG) { System.currentTimeMillis() / 1000 }
        globals["millisTime"] = method(listOf(), Types.LONG) { System.currentTimeMillis() }
        globals["sleep"] = method(listOf(Types.LONG), Types.VOID) {
            Thread.sleep(it[0] as Long)
        }
    }
}