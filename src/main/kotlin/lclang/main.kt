package lclang

import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.libs.std.StdLibrary
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.apache.commons.cli.*
import org.mozilla.universalchardet.UniversalDetector
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Paths
import java.util.*
import java.util.jar.JarFile
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

    try {
        val lexer = lclangLexer(CharStreams.fromString(read(executeFile)))
        val tokens = CommonTokenStream(lexer)
        val parser = lclangParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(ErrorListener(executeFile.path.toString()))

        val tree = parser.file()

        val eval = LCFileVisitor(executeFile.path.toString()).apply {
            libraries.add(StdLibrary())

            val libDir = File(System.getProperty("libsPath", "./libs"))
            if (libDir.exists() || libDir.mkdir()) {
                val files = libDir.listFiles()
                if(files != null) {
                    for (libJar in files) {
                        if(libJar.name.endsWith(".jar"))
                            loadJarLibrary(this, libJar)
                    }
                }
            }
        }

        eval.visit(tree)
    }catch (e: LCLangException){
        println("\u001B[31m"+e.message)
        exitProcess(1)
    }
}

fun read(file: File): String {
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

private fun loadJarLibrary(executor: LCFileVisitor, file: File) {
    val jarFile = JarFile(file)
    val e = jarFile.entries()
    val urls = arrayOf(URL("jar:file:" + file.path + "!/"))
    val cl = URLClassLoader.newInstance(urls)
    while (e.hasMoreElements()) {
        val je = e.nextElement()
        if (je.isDirectory || !je.name.endsWith(".class")) {
            continue
        }

        val className = je.name.substring(0, je.name.length - 6)
            .replace('/', '.')
        val c = cl.loadClass(className)
        if (Library::class.java.isAssignableFrom(c)) executor.libraries.add(c.newInstance() as Library)
    }
}