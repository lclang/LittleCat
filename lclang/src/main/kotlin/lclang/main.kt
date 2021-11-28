package lclang

import lclang.exceptions.LCLangRuntimeException
import lclang.libs.Library
import lclang.libs.lang.classes.ArrayClass
import lclang.libs.lang.classes.StringClass
import lclang.utils.Utils
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.mozilla.universalchardet.UniversalDetector
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Paths
import java.util.*
import java.util.jar.JarFile
import kotlin.system.exitProcess


const val ERROR_COLOR = "\u001B[31m"
const val RESET_COLOR = "\u001B[0m"

fun main(cliArgs: Array<String>) {
    val libDir = File(System.getProperty("libsPath", "./libs"))
    if (libDir.exists() || libDir.mkdir()) {
        val files = libDir.listFiles()
        if(files != null) {
            for (file in files) {
                if(file.name.endsWith(".jar"))
                    Global.javaLibraries.addAll(loadJarLibrary(file))
                else if(file.name.endsWith(".lcat"))
                    Global.libraries.add(LCRootExecutor(file.absolutePath.toString()).apply {
                        try {
                            runInput(file.readText())
                        } catch (e: LCLangRuntimeException){
                            println(ERROR_COLOR+e.message+RESET_COLOR)
                        } catch (e: Exception){
                            println(ERROR_COLOR+e::class.java.simpleName+": "+e.message+RESET_COLOR)
                        }
                    })
            }
        }
    }

    if(cliArgs.isEmpty()){
        val scanner = Scanner(System.`in`)
        println("Little cat ${Global.version} (Build date: ${Global.buildTime})")
        val file = LCRootExecutor("file.lcat")
        file.runInput("")

        var data = ""
        var running = true
        Runtime.getRuntime().addShutdownHook(Thread {
            running = false
        })

        fun read(): String? {
            while (running) {
                if(scanner.hasNextLine())
                    return scanner.nextLine()
            }

            return null
        }

        while (running) {
            print("> ")

            when (val code = read()) {
                ":code" -> println(data)
                ":reset" -> {
                    data = ""
                    file.classes.clear()
                    file.globals.clear()
                    file.executor.variables.clear()

                    print("File reset")
                }

                null -> {}

                else -> {
                    data += code + "\n\r"

                    try {
                        file.runInput(code)
                    } catch (e: LCLangRuntimeException){
                        println(ERROR_COLOR+e.message+RESET_COLOR)
                    } catch (e: Exception){
                        println(ERROR_COLOR+e.javaClass.simpleName+": "+e.message+RESET_COLOR)
                    }
                }
            }
        }
    }

    val args = cliArgs.toMutableList()
    val file: String = args[0]
    args.removeAt(0)

    var filePath = Paths.get(file)
    if(!filePath.isAbsolute) filePath = Paths.get(
            System.getProperty("user.dir"),
            file
    ).normalize()

    val executeFile = File(filePath.toString())

    if(!executeFile.exists()){
        println(ERROR_COLOR+"File "+executeFile.name+" not exists"+RESET_COLOR)
        exitProcess(1)
    }

    if(executeFile.length()==0L) return

    try {
        val executor = LCRootExecutor(executeFile.absolutePath.toString())
        executor.executor.variables["args"] = ArrayClass(args.map {
            StringClass.get(
                it
            )
        }).asValue()

        executor.runInput(Utils.readFile(executeFile, UniversalDetector.detectCharset(executeFile)))
    } catch (e: LCLangRuntimeException){
        println(ERROR_COLOR+e.message+RESET_COLOR)
        exitProcess(1)
    } catch (e: Exception){
        println(ERROR_COLOR+e::class.java.simpleName+": "+e.message+RESET_COLOR)
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

fun LCRootExecutor.runInput(input: String) {
    val lexer = lclangLexer(CharStreams.fromString(input))
    val parser = lclangParser(CommonTokenStream(lexer))
    parser.removeErrorListeners()
    parser.addErrorListener(LCLangErrorListener(path))

    LCCompiler.instance.fillFile(this, parser.file())
    execute()
}