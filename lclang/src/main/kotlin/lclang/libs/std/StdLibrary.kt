package lclang.libs.std

import lclang.*
import lclang.exceptions.LCLangException
import lclang.libs.Library
import lclang.libs.lang.classes.ArrayClass
import lclang.libs.lang.classes.BoolClass
import lclang.libs.lang.classes.NullClass
import lclang.libs.lang.classes.StringClass
import lclang.libs.lang.classes.numbers.IntClass
import lclang.libs.lang.classes.numbers.LongClass
import lclang.libs.std.classes.*
import lclang.methods.Method
import lclang.types.CallableType
import java.util.regex.Pattern
import kotlin.system.exitProcess


class StdLibrary: Library("std") {

    init {
        globals["LC_VERSION"] = StringClass.get(Global.version).asValue()
        globals["LC_BUILD"] = IntClass.get(Global.buildTime).asValue()
        classes["Socket"] = SocketClass.instance
        classes["Output"] = OutputClass.instance
        classes["Input"] = InputClass.instance
        classes["File"] = FileClass()

        globals["math"] = MathClass.instance.asValue()
        globals["std"] = StdClass().asValue()

        globals["thread"] = void(CallableType()) {
            val method = it[0] as Method
            Thread {
                method.call(this, listOf())
            }.start()
        }

        globals["assert"] = void(BoolClass.type) { args ->
            if(args[0]== BoolClass.FALSE)
                throw LCLangException("Assertion Error", "Value is false", this)
        }

        globals["exit"] = void(IntClass.type) { exitProcess((it[0] as IntClass).value) }
        globals["time"] = method(listOf(), LongClass.type) { LongClass.get(System.currentTimeMillis() / 1000) }
        globals["millisTime"] = method(listOf(), LongClass.type) { LongClass.get(System.currentTimeMillis()) }
        globals["sleep"] = void(LongClass.type) {
            Thread.sleep((it[0] as LongClass).value)
        }

        globals["regexMatch"] = method(listOf(StringClass.type, StringClass.type), ArrayClass.type) {
            val matcher = Pattern.compile(it[0].toString(this))
                .matcher(it[1].toString(this))

            if (!matcher.find()) return@method BoolClass.FALSE

            val array =
                ArrayClass(listOf(StringClass.get(matcher.group(0))))
            for (i in 0 until matcher.groupCount()) {
                val group = matcher.group(i+1)
                array.add(if(group!=null)
                    StringClass.get(group)
                else NullClass.instance)
            }

            return@method array
        }
    }

    inner class StdClass : LCClass("std") {
        init {
            executor.variables["output"] = OutputClass(System.out).asValue()
            executor.variables["input"] = InputClass(System.`in`).asValue()
            globals["classesCount"] = Value(IntClass.type) { IntClass.get(classesCount) }
            globals["getProperty"] = method(listOf(StringClass.type), StringClass.type) {
                StringClass.get(System.getProperty(it[0].toString(this), ""))
            }
        }
    }
}