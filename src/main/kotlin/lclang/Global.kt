package lclang

import java.util.*

object Global {
    val version: String
    val buildTime: String
    val libraries = ArrayList<LCFileVisitor>()

    init {
        val prop = ResourceBundle.getBundle("build")
        version = prop.getString("version")
        buildTime = prop.getString("buildTime")
    }
}