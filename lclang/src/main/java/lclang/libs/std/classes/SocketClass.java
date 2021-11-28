package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.types.Types;

import java.io.IOException;
import java.net.Socket;


public class SocketClass extends LibraryClass {
    public static final String name = "Socket";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final SocketClass instance = new SocketClass();

    public SocketClass(Socket socket) {
        this();
        globals.put("getInput", method((caller, lcClasses) -> {
                    try {
                        return new InputClass(socket.getInputStream());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, InputClass.type).asValue());

        globals.put("getOutput", method((caller, lcClasses) -> {
                    try {
                        return new OutputClass(socket.getOutputStream());
                    } catch (IOException e) {
                        throw new LCLangIOException(e.getMessage(), caller);
                    }
                }, OutputClass.type).asValue());

        globals.put("isConnected", method((caller, lcClasses) -> BoolClass.get(socket.isConnected()),
                BoolClass.type).asValue());
        globals.put("isClosed", method((caller, lcClasses) -> BoolClass.get(socket.isClosed()),
                BoolClass.type).asValue());
        globals.put("getPort", method((caller, lcClasses) -> IntClass.get(socket.getPort()),
                IntClass.type).asValue());

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
            int port = ((IntClass) arguments.get(1)).value;
            try {
                return new SocketClass(new Socket(arguments.get(0).toString(caller), port));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, StringClass.type, IntClass.type, type);
    }
}
