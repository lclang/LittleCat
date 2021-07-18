package lclang.libs

import lclang.methods.Method

abstract class Library {
    val methods = HashMap<String, Method>()
}