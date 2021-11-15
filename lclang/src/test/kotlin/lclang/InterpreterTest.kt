package lclang

import lclang.libs.TestLibrary
import lclang.libs.lang.LangLibrary
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
                val output = StringBuilder()

                Global.libraries.clear()
                Global.javaLibraries.clear()
                Global.javaLibraries.add(TestLibrary(output))
                Global.javaLibraries.add(LangLibrary())

                val contents = file.readText().split(Regex("--OUTPUT--\\R"))
                val fileScript = contents[0]
                val needOutput = contents[1]

                val visitor = LCRootExecutor(file.path.toString())
                val lexer = lclangLexer(CharStreams.fromString(fileScript))
                val tokens = CommonTokenStream(lexer)
                val parser = lclangParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ErrorListener(visitor))

                var startTime = System.nanoTime()
                val tree = parser.file()
                var endTime = System.nanoTime()
                val parseTime = endTime-startTime

                startTime = System.nanoTime()
                compiler.fillFile(visitor, tree)
                endTime = System.nanoTime()
                val compileTime = endTime-startTime


                startTime = System.nanoTime()
                visitor.execute()
                endTime = System.nanoTime()

                val executeTime = endTime-startTime

                println("All time: ${parseTime+executeTime+compileTime}ns / ${(parseTime+executeTime+compileTime)/1000000}ms")
                println("Execute time: ${executeTime}ns / ${(executeTime)/1000000}ms")
                println("Compile time: ${compileTime}ns / ${(compileTime)/1000000}ms")
                println("Parse time: ${parseTime}ns/  ${(parseTime)/1000000}ms")
                println()
                println(output)

                assertEquals(needOutput.replace(Regex("\\R"), "\n"),
                    output.toString().replace(Regex("\\R"), "\n"))
            })
        }

        return tests.stream()
    }
}