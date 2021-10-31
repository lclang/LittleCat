package lclang.libs.lang

import lclang.LCClass

class BoolClass(): LCClass("bool") {
    var bool: Boolean = false
    constructor(bool: Boolean): this() {
        this.bool = bool
    }

    override fun equals(other: Any?): Boolean {
        if(other is BoolClass)
            return other.bool == bool

        return false
    }

    override fun toString(): String = bool.toString()
    override fun hashCode(): Int = bool.hashCode()

    companion object {
        val TRUE = BoolClass(true)
        val FALSE = BoolClass()
    }
}