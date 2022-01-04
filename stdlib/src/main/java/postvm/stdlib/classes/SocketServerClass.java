package postvm.stdlib.classes;

import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerClass extends LibraryClass {
    public static final String name = "SocketServer";
    public static final SocketServerClass instance = new SocketServerClass();
    public static final Type type = instance.classType;

    public SocketServerClass() {
        super(name);
        constructor = method((caller, args) -> {
            int port = args.get(1).cast(IntClass.class).value.intValue();

            try {
                return new SocketServerClass(new ServerSocket(port));
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