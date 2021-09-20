package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.lang.StringClass
import lclang.libs.Library
import lclang.libs.std.classes.*
import lclang.methods.LibraryMethod
import lclang.methods.Method
import lclang.types.BaseType
import lclang.types.CallableType
import lclang.types.Type
import lclang.types.Types
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import kotlin.system.exitProcess

class StdLibrary: Library("std") {

    init {
        classes["Socket"] = SocketClass(this)

        val output = OutputClass(System.out, this)
        globals["output"] = output.create()

        globals["LC_VERSION"] = Value(Types.STRING, StringClass(Info.version, fileVisitor))
        globals["math"] = MathClass(this).create()
        globals["input"] = InputClass(System.`in`,this).create()

        globals["println"] = object: LibraryMethod(listOf(Types.ANY), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println(args[0])

                return null
            }
        }

        globals["require"] = object: LibraryMethod(listOf(Types.STRING), Types.ANY) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                val requiredFile = File(File(fileVisitor.path).parent, args[0].toString())
                if(!requiredFile.exists())
                    throw LCLangException("Require", "file "+args[0]+" not found", 0, 0,
                        fileVisitor.path)
                else if(requiredFile.length()==0L)
                    return null

                val lexer = lclangLexer(CharStreams.fromString(requiredFile.readText()))
                val tokens = CommonTokenStream(lexer)
                val parser = lclangParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ErrorListener(requiredFile.path.toString()))

                val eval = LCFileVisitor(requiredFile.path.toString()).apply {
                    libraries.addAll(fileVisitor.libraries)
                    execute(parser.file())
                }

                return eval.variables["export"]?.get?.let { it() }
            }
        }

        globals["thread"] = object : Method(listOf(CallableType(listOf(), Types.VOID)), Types.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Value>): Any? {
                val method = args[0] as Method
                Thread {
                    method.call(this@StdLibrary, listOf())
                }.start()

                return null
            }
        }

        globals["printError"] = object: LibraryMethod(listOf(Types.ANY), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println("$ERROR_COLOR${args[0]}")
                return null
            }
        }

        globals["assert"] = method(listOf(Types.BOOL)) { args, file ->
            if(args[0]==false) throw LCLangException("Assertion Error", "Value is false", 0, 0, file.path)
        }

        globals["exit"] = object: LibraryMethod(listOf(Types.INT), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                exitProcess(args[0] as Int)
            }
        }

        globals["openFile"] = method(listOf(Types.STRING), Type(FILE_CLASSNAME)) { list, file ->
            FileClass(File(list[0].toString()), file)
        }

        globals["time"] = object: LibraryMethod(listOf(), Types.LONG) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return System.currentTimeMillis() / 1000
            }
        }

        globals["millisTime"] = object: LibraryMethod(listOf(), Types.LONG) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return System.currentTimeMillis()
            }
        }

        globals["sleep"] = object: LibraryMethod(listOf(Types.LONG), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                Thread.sleep(args[0] as Long)

                return null
            }
        }
    }
}