package lclang

import lclang.libs.Library
import lclang.libs.lang.LangLibrary
import lclang.libs.reflection.ReflectionLibrary
import lclang.libs.std.StdLibrary
import java.util.*

object Global {
    val version: String
    val buildTime: Int
    val libraries = ArrayList<LCRootExecutor>()
    val javaLibraries = arrayListOf<Library>()

    init {
        val prop = ResourceBundle.getBundle("build")
        version = prop.getString("version")
        buildTime = prop.getString("buildTime").toInt()

        javaLibraries.add(LangLibrary())
        javaLibraries.add(StdLibrary())
        javaLibraries.add(ReflectionLibrary())
    }
}