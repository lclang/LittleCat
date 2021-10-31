package lclang

class Caller(
    val root: LCRootExecutor,
    val line: Int,
    val column: Int,
    val prevCaller: Caller? = null
) {
    fun toList(): MutableList<Caller> {
        return (prevCaller?.toList() ?: mutableListOf())
            .apply { add(this@Caller) }
    }
}