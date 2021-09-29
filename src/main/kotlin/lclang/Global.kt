package lclang

import lclang.libs.Library
import lclang.libs.std.StdLibrary
import java.util.*

object Global {
    val version: String
    val buildTime: String
    val libraries = ArrayList<LCRootExecutor>()
    val javaLibraries = arrayListOf<Library>()

    init {
        val prop = ResourceBundle.getBundle("build")
        version = prop.getString("version")
        buildTime = prop.getString("buildTime")

        javaLibraries.add(StdLibrary())
    }
}