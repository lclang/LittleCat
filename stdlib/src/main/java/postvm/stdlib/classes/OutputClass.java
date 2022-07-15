package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;

import java.io.*;
import java.util.List;

public class OutputClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Output",
            ObjectClass.PROTOTYPE,
            Utils.listOf(CallableType.get(NumberClass.PROTOTYPE.type))
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            Method method = (Method) PostVMClass.instances.get(args[0]);
            return new OutputClass(caller, new OutputStream() {
                @Override
                public void write(int b) {
                    method.call(caller, new int[]{
                            NumberClass.get(b)
                    });
                }
            }).classId;
        }
    };

    public PrintStream printer;

    public OutputClass(Caller caller, OutputStream stream) {
        super(caller, PROTOTYPE);
        try {
            printer = new PrintStream(stream, false, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {}
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "flush": return voidMethod((caller, args) -> printer.flush());
            case "close": return voidMethod((caller, args) -> printer.close());
            case "accept": return voidMethod((caller, args) -> {
                InputClass input = (InputClass) args[0];

                try {
                    String line;
                    while ((line = input.reader.readLine())!=null)
                        printer.println(line);
                }catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }

            }, InputClass.PROTOTYPE.type);
            case "write": return voidMethod((caller, args) -> printer.write(args[0]
                    .cast(NumberClass.class)
                    .value.byteValue()), NumberClass.TYPE);
            case "print": return voidMethod((caller, args) ->
                    printer.print(args[0].toString(caller)), ObjectClass.OBJECT_TYPE);
            case "println": return voidMethod((caller, args) ->
                    printer.println(args[0].toString(caller)), ObjectClass.OBJECT_TYPE);
            case "printf": return voidMethod((caller, args) -> {
                String main = args[0].toString(caller);
                List<Integer> classes = ((ArrayClass) args[1]).value;
                String[] printArgs = new String[classes.size()];
                for (int i = 0; i < classes.size(); i++) {
                    printArgs[i] = PostVMClass.instances.get(classes.get(i)).toString(caller);
                }

                printer.printf(main, (Object[]) printArgs);
            }, ObjectClass.OBJECT_TYPE, ArrayClass.type);
        }

        return super.loadGlobal(clazz, target);
    }
}
