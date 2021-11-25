package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.BoolClass;
import lclang.libs.lang.IntClass;
import lclang.libs.lang.LibraryClass;
import lclang.types.Types;

import java.io.IOException;
import java.net.Socket;


public class SocketClass extends LibraryClass {
    public static final String name = "Socket";
    public static final SocketClass instance = new SocketClass();

    public SocketClass(Socket socket) {
        this();
        globals.put("getInput", method((caller, lcClasses) -> {
                    try {
                        return new InputClass(socket.getInputStream());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, new Types.MagicType(InputClassKt.INPUT_CLASSNAME)).asValue());

        globals.put("getOutput", method((caller, lcClasses) -> {
                    try {
                        return new OutputClass(socket.getOutputStream());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, new Types.MagicType(OutputClassKt.OUTPUT_CLASSNAME)).asValue());

        globals.put("isConnected", method((caller, lcClasses) -> BoolClass.get(socket.isConnected()),
                Types.BOOL).asValue());
        globals.put("isClosed", method((caller, lcClasses) -> BoolClass.get(socket.isClosed()),
                Types.BOOL).asValue());
        globals.put("getPort", method((caller, lcClasses) -> IntClass.Companion.get(socket.getPort()),
                Types.INT).asValue());

        globals.put("close", voidMethod((caller, lcClasses) -> {
            try {
                socket.close();
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }).asValue());
    }

    private SocketClass() {
        super(name);
        constructor = method((caller, arguments) -> {
            int port = ((IntClass) arguments.get(1)).getInt();
            try {
                return new SocketClass(new Socket(arguments.get(0).toString(caller), port));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, Types.STRING, Types.INT, getType());
    }

    public static Types.MagicType getType() {
        return new Types.MagicType(name);
    }
}
