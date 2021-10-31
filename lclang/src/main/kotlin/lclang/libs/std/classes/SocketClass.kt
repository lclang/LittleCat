package lclang.libs.std.classes

import lclang.LCClass
import lclang.constructor
import lclang.libs.lang.BoolClass
import lclang.libs.lang.IntClass
import lclang.method
import lclang.methods.Method
import lclang.types.Types
import lclang.void
import java.net.Socket

class SocketClass() : LCClass("Socket"){
    override var constructor: Method? = constructor(listOf(Types.STRING, Types.INT)) {
        SocketClass(Socket(it[0].toString(), (it[1] as IntClass).int))
    }

    constructor(socket: Socket): this() {
        globals["input"] = InputClass(socket.getInputStream()).asValue()
        globals["output"] = OutputClass(socket.getOutputStream()).asValue()
        globals["close"] = void { socket.close() }
        globals["isConnected"] = method(returnType = Types.BOOL) { BoolClass(socket.isConnected) }
        globals["getPort"] = method(returnType = Types.INT) { IntClass(socket.port) }
    }
}