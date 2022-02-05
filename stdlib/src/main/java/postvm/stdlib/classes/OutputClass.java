package postvm.stdlib.classes;

import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class OutputClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Output",
            PostVMClass.PROTOTYPE,
            Utils.listOf(CallableType.get(IntClass.PROTOTYPE.type))
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            Method method = (Method) args.get(0);
            return new OutputClass(caller, new OutputStream() {
                @Override
                public void write(int b) {
                    method.call(caller, Collections.singletonList(IntClass.get(b)));
                }
            });
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
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "flush": return voidMethod((caller, args) -> printer.flush());
            case "close": return voidMethod((caller, args) -> printer.close());
            case "accept": return voidMethod((caller, args) -> {
                InputClass input = (InputClass) args.get(0);

                try {
                    String line;
                    while ((line = input.reader.readLine())!=null)
                        printer.println(line);
                }catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }

            }, InputClass.PROTOTYPE.type);
            case "write": return voidMethod((caller, args) -> printer.write(args.get(0)
                    .cast(NumberClass.class)
                    .value.byteValue()), NumberClass.TYPE);
            case "print": return voidMethod((caller, args) ->
                    printer.print(args.get(0).toString(caller)), PostVMClass.OBJECT_TYPE);
            case "println": return voidMethod((caller, args) ->
                    printer.println(args.get(0).toString(caller)), PostVMClass.OBJECT_TYPE);
            case "printf": return voidMethod((caller, args) -> {
                String main = args.get(0).toString(caller);
                List<PostVMClass> classes = ((ArrayClass) args.get(1)).value;
                String[] printArgs = new String[classes.size()];
                for (int i = 0; i < classes.size(); i++) {
                    printArgs[i] = classes.get(i).toString(caller);
                }

                printer.printf(main, (Object[]) printArgs);
            }, PostVMClass.OBJECT_TYPE, ArrayClass.type);
        }

        return super.loadGlobal(target);
    }
}
