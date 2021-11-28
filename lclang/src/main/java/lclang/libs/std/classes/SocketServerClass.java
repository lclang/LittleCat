package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.types.Types;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerClass extends LibraryClass {
    public static final String name = "SocketServer";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final SocketServerClass instance = new SocketServerClass();

    public SocketServerClass() {
        super(name);
        constructor = method((caller, args) -> {
            try {
                return new SocketServerClass(new ServerSocket(((IntClass) args.get(0)).value));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, IntClass.type, type);
    }

    public SocketServerClass(ServerSocket server) {
        this();

        globals.put("accept", method((caller, lcClasses) -> {
            try {
                return new SocketClass(server.accept());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, SocketClass.type).asValue());
    }
}
