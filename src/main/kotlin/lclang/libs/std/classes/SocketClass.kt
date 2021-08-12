package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.Value
import lclang.method
import lclang.methods.Method
import lclang.types.Type
import lclang.types.Types
import java.net.Socket

class SocketClass(fileVisitor: LCFileVisitor) : LCClass("Socket", fileVisitor){
    override val constructor: Method = method(listOf(Types.STRING, Types.INT), classType) { args, _ ->
        SocketClass(Socket(args[0].toString(), args[1] as Int), fileVisitor)
    }

    constructor(socket: Socket, fileVisitor: LCFileVisitor): this(fileVisitor) {
        globals["getInput"] = method(returnType = Type("\\Input")) { _, _ -> InputClass(socket.getInputStream(), fileVisitor) }
        globals["getOutput"] = method(returnType = Type("\\Output")) { _, _ -> OutputClass(socket.getOutputStream(), fileVisitor) }
        globals["close"] = method { _, _ -> socket.close() }
    }
}