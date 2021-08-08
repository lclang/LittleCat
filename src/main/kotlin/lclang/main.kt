package lclang

import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.libs.std.StdLibrary
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.apache.commons.cli.*
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Paths
import java.util.jar.JarFile
import kotlin.system.exitProcess

const val ERROR_COLOR = "\u001B[31m"

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
        println(ERROR_COLOR+"File "+executeFile.name+" not exists")
        exitProcess(1)
    }

    if(executeFile.length()==0L) return

    try {
        val lexer = lclangLexer(CharStreams.fromString(executeFile.readText()))
        val tokens = CommonTokenStream(lexer)
        val parser = lclangParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(ErrorListener(executeFile.path.toString()))

        LCFileVisitor(executeFile.path.toString()).apply {
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

            execute(parser.file())
        }
    }catch (e: LCLangException){
        println(ERROR_COLOR+e.message)
        exitProcess(1)
    }
}

private fun loadJarLibrary(executor: LCFileVisitor, file: File) {
    val jarFile = JarFile(file)
    val entries = jarFile.entries()
    val classLoader = URLClassLoader.newInstance(arrayOf(URL("jar:file:" + file.path + "!/")))

    while (entries.hasMoreElements()) {
        val je = entries.nextElement()
        if (je.isDirectory || !je.name.endsWith(".class")) {
            continue
        }

        val className = je.name.substring(0, je.name.length - 6)
            .replace('/', '.')
        val clazz = classLoader.loadClass(className)
        if (Library::class.java.isAssignableFrom(clazz))
            executor.libraries.add(clazz.newInstance() as Library)
    }
}