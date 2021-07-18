package lclang

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.apache.commons.cli.*
import org.mozilla.universalchardet.UniversalDetector
import java.io.File
import java.nio.file.Paths
import java.util.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val options = Options().apply {
        addOption(Option("f",
              "file",
               true,
            "FilePath").apply {
            isRequired = true
        })
    }

    val cmdParser = DefaultParser()
    val formatter = HelpFormatter()
    val cmd: CommandLine

    try {
        cmd = cmdParser.parse(options, args)
    } catch (e: ParseException) {
        println(e.message)
        formatter.printHelp("lcat", options)
        exitProcess(1)
    }

    val executeFile = File(
        Paths.get(
            System.getProperty("user.dir"),
            cmd.getOptionValue("file")
        ).normalize().toString()
    )

    if(!executeFile.exists()){
        println("File "+executeFile.name+" not exists")
        exitProcess(1)
    }

    if(executeFile.length()==0L) {
        println(executeFile.path)
        return
    }

    val lexer = lclangLexer(CharStreams.fromString(read(executeFile)))
    val tokens = CommonTokenStream(lexer)
    val parser = lclangParser(tokens)
    val tree = parser.file()

    val eval = LCVisitor()
    eval.visit(tree)
}

private fun read(file: File): String {
    Scanner(file, UniversalDetector.detectCharset(file)).use {
        val value = StringBuilder()
        while (it.hasNextLine()) {
            value.append(it.nextLine()).append("\n")
        }

        value.replace(Regex("[\r\t]"), "").apply {
            return if (startsWith("\uFEFF")) {
                substring(1)
            }else this
        }
    }
}