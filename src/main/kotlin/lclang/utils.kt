package lclang

import lclang.types.BaseType

fun List<BaseType>.isAccept(array: List<BaseType>): Int {
    if(size!=array.size) return array.size-1
    for((i, type) in this.withIndex())
        if(!type.isAccept(array[i]))
            return i

    return -1
}