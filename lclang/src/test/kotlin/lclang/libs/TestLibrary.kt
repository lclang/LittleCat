package lclang.libs

import lclang.types.Types
import lclang.void

class TestLibrary(output: StringBuilder): Library("test") {
    init {
        globals["println"] = void(Types.ANY) {
            output.append("${it[0]}\r\n")
        }

        globals["print"] = void(Types.ANY) {
            output.append(it[0])
        }
    }
}