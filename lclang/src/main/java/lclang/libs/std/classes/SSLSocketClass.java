package lclang.libs.std.classes;

import lclang.exceptions.LCLangIOException;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.types.Types;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class SSLSocketClass extends LibraryClass {
    public static final String name = "SSLSocket";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final SSLSocketClass instance = new SSLSocketClass();
    public static final SocketFactory factory = SSLSocketFactory.getDefault();

    private SSLSocketClass() {
        super(name);
        extendsClass = SocketClass.instance;
        constructor = method((caller, arguments) -> {
            int port = ((IntClass) arguments.get(1)).value;
            try {
                return new SSLSocketClass((SSLSocket) factory.
                        createSocket(arguments.get(0).toString(caller), port));

            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }, StringClass.type, IntClass.type, type);
    }

    public SSLSocketClass(SSLSocket socket) {
        super(name);

        extendsClass = new SocketClass(socket);
        accept(extendsClass);

        globals.put("startHandshake", voidMethod((caller, lcClasses) -> {
            try {
                socket.startHandshake();
            } catch (IOException e) {
                throw new LCLangIOException(e.getMessage(), caller);
            }
        }).asValue());
    }
}
