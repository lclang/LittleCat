package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.libs.std.classes.MathClass
import lclang.methods.Method
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import kotlin.system.exitProcess
import java.util.*

class StdLibrary: Library("std") {

    init {
        globals["math"] = Value({Type("math")}, { MathClass(this) })
        globals["println"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println(args[0])

                return null
            }
        }

        globals["require"] = object: Method(listOf(Type.STRING), Type.ANY) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                val requiredFile = File(File(fileVisitor.path).parent, args[0].toString())
                if(!requiredFile.exists())
                    throw LCLangException("Require", "file "+args[0]+" not found", 0, 0,
                        fileVisitor.path)
                else if(requiredFile.length()==0L)
                    return null

                val lexer = lclangLexer(CharStreams.fromString(read(requiredFile)))
                val tokens = CommonTokenStream(lexer)
                val parser = lclangParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ErrorListener(requiredFile.path.toString()))

                val eval = LCFileVisitor(requiredFile.path.toString()).apply {
                    libraries.addAll(fileVisitor.libraries)
                    visitFile(parser.file())
                }

                return eval.variables["export"]?.get?.let { it() }
            }
        }

        globals["print"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                print(args[0])

                return null
            }
        }

        globals["readLine"] = object: Method(listOf(), Type.STRING) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                val scanner = Scanner(System.`in`)
                return scanner.nextLine()
            }
        }

        globals["printError"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println("\u001B[31m${args[0]}")
                return null
            }
        }

        globals["exit"] = object: Method(listOf(Type.INT), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                exitProcess(args[0] as Int)
            }
        }

        globals["time"] = object: Method(listOf(), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return System.currentTimeMillis() / 1000
            }
        }
    }
}