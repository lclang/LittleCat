package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.ObjectClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.library.classes.numbers.NumberClass;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "SocketServer", ObjectClass.PROTOTYPE, Utils.listOf(NumberClass.TYPE)
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            int port = PostVMClass.instances.get(args[0]).cast(NumberClass.class).value.intValue();

            try {
                return new SocketServerClass(caller, new ServerSocket(port)).classId;
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
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "accept": return method(SocketClass.PROTOTYPE.type, (caller, args) -> {
                try {
                    return new SocketClass(caller, server.accept()).classId;
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }

        return super.loadGlobal(clazz, target);
    }
}
