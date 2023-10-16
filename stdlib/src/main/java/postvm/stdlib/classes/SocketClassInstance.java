package postvm.stdlib.classes;

import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;

import java.io.IOException;
import java.net.Socket;


public class SocketClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Socket",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(StringClassInstance.PROTOTYPE.type, NumberClassInstance.PROTOTYPE.type)
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            int port = PostVMClassInstance.instances.get(args[1]).cast(NumberClassInstance.class).value.intValue();

            try {
                return new SocketClassInstance(caller, new Socket(PostVMClassInstance.instances.get(args[0]).cast(StringClassInstance.class).string, port)).classId;
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }
    };

    public Socket socket;

    public SocketClassInstance(int caller, Socket socket) {
        super(caller, PROTOTYPE);
        this.socket = socket;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "getInput": return methodOld(InputClassInstance.PROTOTYPE.type, (caller, args) -> {
                try {
                    return new InputClassInstance(caller, socket.getInputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
            case "getOutput": return methodOld(OutputClassInstance.PROTOTYPE.type, (caller, args) -> {
                try {
                    return new OutputClassInstance(caller, socket.getOutputStream());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
            case "isConnected": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(socket.isConnected()));
            case "isClosed": return method(BoolClassInstance.type, (caller, args) -> BoolClassInstance.get(socket.isClosed()));
            case "getPort": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(socket.getPort()));
            case "close": return voidMethod((caller, args) -> {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }

        return super.loadMethod(clazz, target);
    }
}
