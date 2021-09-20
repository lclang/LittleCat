package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.method
import lclang.methods.Method
import lclang.types.Types
import java.net.Socket

class SocketClass(fileVisitor: LCFileVisitor) : LCClass("Socket", fileVisitor){
    override val constructor: Method = method(listOf(Types.STRING, Types.INT), classType) {
        SocketClass(Socket(it[0].toString(), it[1] as Int), fileVisitor)
    }

    constructor(socket: Socket, fileVisitor: LCFileVisitor): this(fileVisitor) {
        globals["input"] = InputClass(socket.getInputStream(), fileVisitor).asValue()
        globals["output"] = OutputClass(socket.getOutputStream(), fileVisitor).asValue()
        globals["close"] = method { socket.close() }
        globals["isConnected"] = method(returnType = Types.BOOL) { socket.isConnected }
        globals["getPort"] = method(returnType = Types.INT) { socket.port }
    }
}