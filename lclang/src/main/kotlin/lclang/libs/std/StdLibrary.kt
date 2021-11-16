package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.libs.lang.*
import lclang.libs.std.classes.*
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Types
import java.util.regex.Pattern
import kotlin.system.exitProcess


class StdLibrary: Library("std") {

    init {
        classes["Socket"] = SocketClass()
        classes["Output"] = SocketClass()
        classes["Input"] = SocketClass()
        classes["File"] = FileClass()

        globals["math"] = MathClass().asValue()
        globals["std"] = StdClass().asValue()

        globals["thread"] = void(CallableType()) {
            val method = it[0] as Method
            Thread {
                method.call(this, listOf())
            }.start()
        }

        // DEPRECATED: NEED TRANSFER TO STREAMS.LCAT LIB
        globals["printError"] = void(Types.ANY) {
            println("$ERROR_COLOR${it[0]}")
        }

        globals["assert"] = void(Types.BOOL) { args ->
            if(args[0]==BoolClass.FALSE)
                throw LCLangException("Assertion Error", "Value is false", this)
        }

        globals["exit"] = void(Types.INT) { exitProcess((it[0] as IntClass).int) }
        globals["time"] = method(listOf(), Types.LONG) { LongClass(System.currentTimeMillis() / 1000) }
        globals["millisTime"] = method(listOf(), Types.LONG) { LongClass(System.currentTimeMillis()) }
        globals["sleep"] = void(Types.LONG) {
            Thread.sleep((it[0] as LongClass).long)
        }

        globals["regexMatch"] = method(listOf(Types.STRING, Types.STRING), Types.ARRAY) {
            val matcher = Pattern.compile(it[0].toString())
                .matcher(it[1].toString())

            if (!matcher.find()) return@method BoolClass.FALSE

            val array = ArrayClass(listOf(StringClass(matcher.group(0)).asValue()))
            for (i in 0 until matcher.groupCount()) {
                val group = matcher.group(i+1)
                array.add(if(group!=null)
                    StringClass(group).asValue()
                else Value(Types.UNDEFINED, null))
            }

            return@method array
        }
    }

    inner class StdClass : LCClass("std") {
        init {
            executor.variables["output"] = OutputClass(System.out).asValue()
            executor.variables["input"] = InputClass(System.`in`).asValue()
            globals["classesCount"] = Value(Types.INT) { IntClass(classesCount) }
            globals["getProperty"] = method(listOf(Types.STRING), Types.STRING) {
                StringClass(System.getProperty(it[0].string().string, ""))
            }
        }
    }
}