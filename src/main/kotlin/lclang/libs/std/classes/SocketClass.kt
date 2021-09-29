package lclang.libs.std.classes

import lclang.LCClass
import lclang.constructor
import lclang.method
import lclang.methods.Method
import lclang.types.Types
import java.net.Socket

class SocketClass() : LCClass("Socket"){
    override var constructor: Method = constructor(listOf(Types.STRING, Types.INT), classType) {
        SocketClass(Socket(it[0].toString(), it[1] as Int))
    }

    constructor(socket: Socket): this() {
        globals["input"] = InputClass(socket.getInputStream()).asValue()
        globals["output"] = OutputClass(socket.getOutputStream()).asValue()
        globals["close"] = method { socket.close() }
        globals["isConnected"] = method(returnType = Types.BOOL) { socket.isConnected }
        globals["getPort"] = method(returnType = Types.INT) { socket.port }
    }
}