package postvm.stdlib.classes;

import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
import postvm.methods.MethodInstance;
import postvm.types.CallableType;

import java.io.*;
import java.util.List;

public class OutputClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "Output",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(CallableType.get(NumberClassInstance.PROTOTYPE.type))
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            MethodInstance method = (MethodInstance) PostVMClassInstance.instances.get(args[0]);
            return new OutputClassInstance(caller, new OutputStream() {
                @Override
                public void write(int b) {
                    method.call(caller, new int[]{
                            NumberClassInstance.get(b)
                    });
                }
            }).classId;
        }
    };

    public PrintStream printer;

    public OutputClassInstance(int caller, OutputStream stream) {
        super(caller, PROTOTYPE);
        try {
            printer = new PrintStream(stream, false, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {}
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "flush": return voidMethod((caller, args) -> printer.flush());
            case "close": return voidMethod((caller, args) -> printer.close());
            case "accept": return voidMethod((caller, args) -> {
                InputClassInstance input = (InputClassInstance) args[0];

                try {
                    String line;
                    while ((line = input.reader.readLine())!=null)
                        printer.println(line);
                }catch (IOException e) {
                    throw new LCLangIOException(e.getMessage(), caller);
                }

            }, InputClassInstance.PROTOTYPE.type);
            case "write": return voidMethod((caller, args) -> printer.write(args[0]
                    .cast(NumberClassInstance.class)
                    .value.byteValue()), NumberClassInstance.TYPE);
            case "print": return voidMethod((caller, args) ->
                    printer.print(args[0].toString(caller)), ObjectClassInstance.OBJECT_TYPE);
            case "println": return voidMethod((caller, args) ->
                    printer.println(args[0].toString(caller)), ObjectClassInstance.OBJECT_TYPE);
            case "printf": return voidMethod((caller, args) -> {
                String main = args[0].toString(caller);
                List<Integer> classes = ((ArrayClassInstance) args[1]).value;
                String[] printArgs = new String[classes.size()];
                for (int i = 0; i < classes.size(); i++) {
                    printArgs[i] = PostVMClassInstance.instances.get(classes.get(i)).toString(caller);
                }

                printer.printf(main, (Object[]) printArgs);
            }, ObjectClassInstance.OBJECT_TYPE, ArrayClassInstance.type);
        }

        return super.loadMethod(clazz, target);
    }
}
