package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

public class SocketServerClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "SocketServer", PostVMClass.PROTOTYPE, Utils.listOf()
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            int port = args.get(0).cast(IntClass.class).value;

            try {
                return new SocketServerClass(caller, new ServerSocket(port));
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }
    };

    public ServerSocket server;

    public SocketServerClass(Caller caller, ServerSocket server) {
        super(caller, PROTOTYPE);
        this.server = server;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "accept": return method((caller, args) -> {
                try {
                    return new SocketClass(caller, server.accept());
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            }, SocketClass.PROTOTYPE.type);
        }

        return super.loadGlobal(target);
    }
}
