package postvm.stdlib.classes;

import postvm.exceptions.LCLangIOException;
import postvm.library.classes.BoolClass;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import java.io.IOException;
import java.net.Socket;


public class SocketClass extends LibraryClass {
    public static final String name = "Socket";
    public static final SocketClass instance = new SocketClass();
    public static final Type type = instance.classType;
    public Socket socket;

    public SocketClass(Socket socket) {
        super(name);
        this.socket = socket;
    }

    private SocketClass() {
        super(name);
        constructor = method((caller, arguments) -> {
            int port = arguments.get(1).cast(IntClass.class).value;
            try {
                return new SocketClass(new Socket(arguments.get(0).cast(StringClass.class)
                        .string, port));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, StringClass.type, IntClass.TYPE, type);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "getInput": return method((caller, args) -> {
                try {
                    return new InputClass(socket.getInputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, InputClass.type);
            case "getOutput": return method((caller, args) -> {
                try {
                    return new OutputClass(socket.getOutputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, OutputClass.type);
            case "isConnected": return method((caller, args) -> BoolClass.get(socket.isConnected()),
                    BoolClass.type);
            case "isClosed": return method((caller, args) -> BoolClass.get(socket.isClosed()),
                    BoolClass.type);
            case "getPort": return method((caller, args) -> IntClass.get(socket.getPort()),
                    IntClass.TYPE);
            case "close": return voidMethod((caller, args) -> {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }

        return super.loadGlobal(target);
    }
}
