package lclang

import lclang.exceptions.LCLangException
import lclang.libs.TestLibrary
import lclang.methods.Method
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import java.io.File
import java.util.stream.Stream

@DisplayName("Interpreter Tests")
class InterpreterTest {
    private val testsFile = File("./tests/")

    @TestFactory
    fun run(): Stream<DynamicTest> {
        val tests = ArrayList<DynamicTest>()
        for(file in testsFile.listFiles()!!){
            tests.add(DynamicTest.dynamicTest(file.name) {
                val contents = file.readText().split(Regex("--OUTPUT--\\R"))
                val fileScript = contents[0]
                val needOutput = contents[1]
                val output = StringBuilder()

                val lexer = lclangLexer(CharStreams.fromString(fileScript))
                val tokens = CommonTokenStream(lexer)
                val parser = lclangParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ErrorListener(file.path.toString()))

                var startTime = System.currentTimeMillis()
                val fileContext = parser.file()
                var endTime = System.currentTimeMillis()
                println("Parse time: "+(endTime-startTime)+"ms")

                LCFileVisitor(file.path.toString()).apply {
                    libraries.add(TestLibrary(output))

                    startTime = System.currentTimeMillis()
                    execute(fileContext)
                }

                endTime = System.currentTimeMillis()
                println("Execute time: "+(endTime-startTime)+"ms")
                println(output)
                
                assertEquals(needOutput, output.toString())
            })
        }

        return tests.stream()
    }
}