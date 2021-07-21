package lclang

import lclang.exceptions.LCLangException
import lclang.methods.Method
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.jupiter.api.Test
import java.io.File
import java.lang.StringBuilder

class InterpreterTest {
    val tests = File("./tests/")

    @Test
    fun runTests() {
        for(file in tests.listFiles()!!){
            val contents = read(file).split(Regex("--OUTPUT--\\R"))
            val fileScript = contents[0]
            val needOutput = contents[1]
            val output = StringBuilder()

            try {
                val lexer = lclangLexer(CharStreams.fromString(fileScript))
                val tokens = CommonTokenStream(lexer)
                val parser = lclangParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ErrorListener(file.path.toString()))

                LCFileVisitor(file.path.toString()).apply {
                    methods["println"] = object: Method(listOf(Type.ANY), Type.VOID) {
                        override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                            output.append("${args[0]}\n")
                            return null
                        }
                    }

                    methods["print"] = object: Method(listOf(Type.ANY), Type.VOID) {
                        override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                            output.append(args[0])
                            return null
                        }
                    }

                    visitFile(parser.file())
                }

            }catch (e: LCLangException){
                output.append(e.message+"\n")
            }

            if(needOutput!=output.toString())
                throw Exception("Invalid output in ${file.path}")
        }
    }
}