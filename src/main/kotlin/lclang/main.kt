package lclang

import lclang.exceptions.LCLangException
import lclang.libs.Library
import org.apache.commons.cli.*
import java.io.File
import java.io.PrintStream
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Paths
import java.util.*
import java.util.jar.JarFile
import kotlin.system.exitProcess


const val ERROR_COLOR = "\u001B[31m"
const val RESET_COLOR = "\u001B[0m"

fun main(args: Array<String>) {
    val consoleCharset = System.getProperty("sun.jnu.encoding")
    val libDir = File(System.getProperty("libsPath", "./libs"))

    System.setOut(PrintStream(System.out, true, consoleCharset))

    if (libDir.exists() || libDir.mkdir()) {
        val files = libDir.listFiles()
        if(files != null) {
            for (file in files) {
                if(file.name.endsWith(".jar"))
                    Global.javaLibraries.addAll(loadJarLibrary(file))
                else if(file.name.endsWith(".lcat"))
                    Global.libraries.add(LCRootExecutor(file.absolutePath.toString()).apply {
                        runInput(file.readText())
                    })
            }
        }
    }

    if(args.isEmpty()){
        println("Little cat ${Global.version} (Build date: ${Global.buildTime}; " +
                "Console encoding: ${consoleCharset})")
        val file = LCRootExecutor("file.lcat")
        file.runInput("")

        var data = ""

        val scanner = Scanner(System.`in`, "UTF-8")
        while (true) {
            print("> ")

            when (val code = scanner.nextLine() ?: exitProcess(0)) {
                ":code" -> println(data)
                ":reset" -> {
                    data = ""
                    file.classes.clear()
                    file.globals.clear()
                    file.executor.variables.clear()

                    print("File reset")
                }

                else -> {
                    data += code + "\n\r"

                    try {
                        file.runInput(code)
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

    var filePath = Paths.get(cmd.getOptionValue("file"))
    if(!filePath.isAbsolute) filePath = Paths.get(
            System.getProperty("user.dir"),
            cmd.getOptionValue("file")
            ).normalize()

    val executeFile = File(filePath.toString())

    if(!executeFile.exists()){
        println(ERROR_COLOR+"File "+executeFile.name+" not exists")
        exitProcess(1)
    }

    if(executeFile.length()==0L) return

    try {
        LCRootExecutor(executeFile.absolutePath.toString()).apply {
            runInput(executeFile.readText())
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