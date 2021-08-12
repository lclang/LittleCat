package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import java.net.Socket

class SocketClass(fileVisitor: LCFileVisitor) : LCClass("Socket", fileVisitor){
    constructor(socket: Socket, fileVisitor: LCFileVisitor): this(fileVisitor) {
        globals[""]
    }
}