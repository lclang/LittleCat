package lclang

import lclang.libs.TestLibrary
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

                var startTime = System.currentTimeMillis()
                val fileContext = parser.file()
                var endTime = System.currentTimeMillis()
                val parseTime = endTime-startTime

                val visitor = LCRootExecutor(file.path.toString())
                parser.addErrorListener(ErrorListener(visitor))

                Global.javaLibraries.clear()
                Global.javaLibraries.add(TestLibrary(output))

                startTime = System.currentTimeMillis()
                visitor.execute(fileContext)
                endTime = System.currentTimeMillis()

                val executeTime = endTime-startTime

                println("All time: ${parseTime+executeTime}ms")
                println("Execute time: ${executeTime}ms")
                println("Parse time: ${parseTime}ms")
                println()
                println(output)

                assertEquals(needOutput.replace(Regex("\\R"), "\n"),
                    output.toString().replace(Regex("\\R"), "\n"))
            })
        }

        return tests.stream()
    }
}