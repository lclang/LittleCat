package lclang.libs

import lclang.method
import lclang.types.Types

class TestLibrary(output: StringBuilder): Library("test") {
    init {
        globals["println"] = method(listOf(Types.ANY), Types.VOID) {
            output.append("${it[0]}\r\n")
        }

        globals["print"] = method(listOf(Types.ANY), Types.VOID) {
            output.append(it[0])
        }
    }
}