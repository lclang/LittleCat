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
const val RESET_COLOR = "\u001B[0m"

fun main(args: Array<String>) {
    val libDir = File(System.getProperty("libsPath", "./libs"))
    val includeLibraries = arrayListOf<Library>(StdLibrary())
    if (libDir.exists() || libDir.mkdir()) {
        val files = libDir.listFiles()
        if(files != null) {
            for (libJar in files) {
                if(libJar.name.endsWith(".jar"))
                    includeLibraries.addAll(loadJarLibrary(libJar))
            }
        }
    }

    if(args.isEmpty()){
        println("Little cat 0.1.1")
        val file = LCFileVisitor("file.lcat").apply {
            libraries.addAll(includeLibraries)
        }

        var data = ""
        while (true) {
            print("> ")
            when (val line = readLine()) {
                ":reset" -> {
                    data = ""
                    file.classes.clear()
                    file.globals.clear()
                    file.variables.clear()

                    println("File reset")
                }
                ":code" -> {
                    println(data)
                }
                "exit" -> {
                    exitProcess(0)
                }
                else -> {
                    data += line

                    try {
                        runInput(file, line?:"")
                    } catch (e: LCLangException){
                        println(ERROR_COLOR+e.message+RESET_COLOR)
                    }
                }
            }
        }
    }

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
        LCFileVisitor(executeFile.path.toString()).apply {
            libraries.addAll(includeLibraries)
            runInput(this, executeFile.readText())
        }
    } catch (e: LCLangException){
        println(ERROR_COLOR+e.message)
        exitProcess(1)
    }
}

private fun loadJarLibrary(file: File): List<Library> {
    val libraries = ArrayList<Library>()
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
            libraries.add(clazz.newInstance() as Library)
    }

    return libraries
}