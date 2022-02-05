package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.IntClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.List;


public class SocketClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Socket",
            PostVMClass.PROTOTYPE,
            Utils.listOf(CallableType.get(IntClass.PROTOTYPE.type))
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            int port = args.get(1).cast(IntClass.class).value;

            try {
                return new SocketClass(caller, new Socket(args.get(0).cast(StringClass.class).string, port));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }
    };

    public Socket socket;

    public SocketClass(Caller caller, Socket socket) {
        super(caller, PROTOTYPE);
        this.socket = socket;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "getInput": return method((caller, args) -> {
                try {
                    return new InputClass(caller, socket.getInputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, InputClass.PROTOTYPE.type);
            case "getOutput": return method((caller, args) -> {
                try {
                    return new OutputClass(caller, socket.getOutputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, OutputClass.PROTOTYPE.type);
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
