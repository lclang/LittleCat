package lclang

import java.util.*

object Info {
    val version: String
    val buildTime: String

    init {
        val prop = ResourceBundle.getBundle("build")
        version = prop.getString("version")
        buildTime = prop.getString("buildTime")
    }
}