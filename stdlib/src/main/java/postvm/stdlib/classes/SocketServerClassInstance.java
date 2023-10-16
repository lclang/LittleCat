package postvm.stdlib.classes;

import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClassInstance;
import postvm.library.classes.ObjectClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.NumberClassInstance;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "SocketServer", ObjectClassInstance.PROTOTYPE, Utils.listOf(NumberClassInstance.TYPE)
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            int port = PostVMClassInstance.instances.get(args[0]).cast(NumberClassInstance.class).value.intValue();

            try {
                return new SocketServerClassInstance(caller, new ServerSocket(port)).classId;
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }
    };

    public ServerSocket server;

    public SocketServerClassInstance(int caller, ServerSocket server) {
        super(caller, PROTOTYPE);
        this.server = server;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "accept": return method(SocketClassInstance.PROTOTYPE.type, (caller, args) -> {
                try {
                    return new SocketClassInstance(caller, server.accept()).classId;
                } catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }
            });
        }

        return super.loadMethod(clazz, target);
    }
}
