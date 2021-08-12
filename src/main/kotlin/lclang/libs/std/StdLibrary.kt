package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.lang.StringClass
import lclang.libs.Library
import lclang.libs.std.classes.InputClass
import lclang.libs.std.classes.MathClass
import lclang.methods.LibraryMethod
import lclang.types.Types
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import kotlin.system.exitProcess

class StdLibrary: Library("std") {

    init {
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

        globals["print"] = object: LibraryMethod(listOf(Types.ANY), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                print(args[0])

                return null
            }
        }

        globals["printError"] = object: LibraryMethod(listOf(Types.ANY), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println("\u001B[31m${args[0]}")
                return null
            }
        }

        globals["exit"] = object: LibraryMethod(listOf(Types.INT), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                exitProcess(args[0] as Int)
            }
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