package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.methods.Method
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import kotlin.system.exitProcess
import java.util.*

class StdLibrary: Library() {
    init {
        methods["println"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                println(args[0])

                return null
            }
        }

        methods["require"] = object: Method(listOf(Type.STRING), Type.ANY) {
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

                val eval = LCFileVisitor(requiredFile.path.toString())
                eval.visitFile(parser.file())

                return eval.variables["export"]?.get?.let { it() }
            }
        }

        methods["print"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                print(args[0])

                return null
            }
        }

        methods["readLine"] = object: Method(listOf(), Type.STRING) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                val scanner = Scanner(System.`in`)
                return scanner.nextLine()
            }
        }

        methods["printError"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                error(args[0].toString())
            }
        }

        methods["exit"] = object: Method(listOf(Type.INT), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                exitProcess(args[0] as Int)
            }
        }

        methods["time"] = object: Method(listOf(), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return System.currentTimeMillis() / 1000
            }
        }
    }
}