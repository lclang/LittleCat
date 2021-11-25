package lclang.libs.lang

import lclang.Global
import lclang.libs.Library

class LangLibrary: Library("lang") {
    init {
        globals["LC_VERSION"] = StringClass.get(Global.version).asValue()
        globals["LC_BUILD"] = IntClass.get(Global.buildTime).asValue()

        classes["array"] = ArrayClass.instance
        classes["bool"] = BoolClass.instance
        classes["char"] = CharClass.instance
        classes["double"] = DoubleClass()
        classes["int"] = IntClass.instance
        classes["long"] = LongClass()
        classes["number"] = NumberClass()
        classes["string"] = StringClass.instance
        classes["null"] = NullClass.NULL
    }
}