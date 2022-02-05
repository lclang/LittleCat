package postvm.stdlib.classes;

import postvm.Caller;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

//public class SSLSocketClass extends LibraryClass {
////    public static final String name = "SSLSocket";
////    public static final SSLSocketClass instance = new SSLSocketClass();
////    public static final SocketFactory factory = SSLSocketFactory.getDefault();
////    public static final Type type = instance.classType;
////    public SSLSocket socket;
////
////    private SSLSocketClass() {
////        super(name);
////        constructor = method((caller, arguments) -> {
////            int port = arguments.get(1).cast(IntClass.class).value;
////            try {
////                return new SSLSocketClass((SSLSocket) factory.
////                        createSocket(arguments.get(0).cast(StringClass.class).string, port));
////
////            } catch (IOException e) {
////                throw new LCLangIOException(e.getMessage(), caller);
////            }
////        }, StringClass.type, IntClass.TYPE, type);
////    }
////
////    public SSLSocketClass(Caller caller, SSLSocket socket) {
////        super(caller);
////        this.socket = socket;
////
////        extendsClass = new SocketClass(caller, socket);
////    }
////
////
////    @Override
////    public PostVMClass loadGlobal(String target) {
////        switch (target) {
////            case "startHandshake": return voidMethod((caller, args) -> {
////                try {
////                    socket.startHandshake();
////                } catch (IOException e) {
////                    throw new LCLangIOException(e.getMessage(), caller);
////                }
////            });
////        }
////
////        return super.loadGlobal(target);
////    }
//}
