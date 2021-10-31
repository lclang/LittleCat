package lclang.libs.lang

import lclang.Global
import lclang.libs.Library

class LangLibrary: Library("lang") {
    init {
        globals["LC_VERSION"] = StringClass(Global.version).asValue()
        globals["LC_BUILD"] = IntClass(Global.buildTime).asValue()

        classes["array"] = ArrayClass()
        classes["int"] = IntClass()
        classes["bool"] = BoolClass()
        classes["char"] = CharClass()
        classes["double"] = DoubleClass()
        classes["int"] = IntClass()
        classes["long"] = LongClass()
        classes["number"] = NumberClass()
        classes["string"] = StringClass()
    }
}