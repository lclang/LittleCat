package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.types.Type;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerClass extends LibraryClass {
    public static final String name = "SocketServer";
    public static final SocketServerClass instance = new SocketServerClass();
    public static final Type type = instance.classType;

    public SocketServerClass() {
        super(name);
        constructor = method((caller, args) -> {
            try {
                return new SocketServerClass(new ServerSocket(args.get(0).cast(IntClass.class).value));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, IntClass.TYPE, type);
    }

    public SocketServerClass(ServerSocket server) {
        this();

        globals.put("accept", method((caller, args) -> {
            try {
                return new SocketClass(server.accept());
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, SocketClass.type));
    }
}
