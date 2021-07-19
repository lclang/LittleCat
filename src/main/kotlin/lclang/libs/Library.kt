package lclang.libs

import lclang.Value
import lclang.methods.Method

abstract class Library {
    val methods = HashMap<String, Method>()
    val globals = HashMap<String, Value>()
}