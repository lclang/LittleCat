package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.CallableType;

import java.io.IOException;
import java.net.Socket;


public class SocketClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Socket",
            ObjectClass.PROTOTYPE,
            Utils.listOf(StringClass.PROTOTYPE.type, NumberClass.PROTOTYPE.type)
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            int port = PostVMClass.instances.get(args[1]).cast(NumberClass.class).value.intValue();

            try {
                return new SocketClass(caller, new Socket(PostVMClass.instances.get(args[0]).cast(StringClass.class).string, port)).classId;
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
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "getInput": return methodOld(InputClass.PROTOTYPE.type, (caller, args) -> {
                try {
                    return new InputClass(caller, socket.getInputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
            case "getOutput": return methodOld(OutputClass.PROTOTYPE.type, (caller, args) -> {
                try {
                    return new OutputClass(caller, socket.getOutputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
            case "isConnected": return method(BoolClass.type, (caller, args) -> BoolClass.get(socket.isConnected()));
            case "isClosed": return method(BoolClass.type, (caller, args) -> BoolClass.get(socket.isClosed()));
            case "getPort": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(socket.getPort()));
            case "close": return voidMethod((caller, args) -> {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }

        return super.loadGlobal(clazz, target);
    }
}
