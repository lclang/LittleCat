package postvm.stdlib;

import postvm.Library;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
import postvm.stdlib.classes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdLibrary extends Library {
    public static final Map<String, Pattern> cachePattern = new HashMap<>();

    public StdLibrary() {
        super("std");
        classes.put("SocketServer", SocketServerClass.instance);
        classes.put("Socket", SocketClass.instance);
        classes.put("SSLSocket", SSLSocketClass.instance);
        classes.put("Output", OutputClass.instance);
        classes.put("Input", InputClass.instance);
        classes.put("File", FileClass.instance);
        classes.put("Math", MathClass.instance);
        classes.put("Thread", ThreadClass.instance);
        classes.put("std", StdClass.instance);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "std": return StdClass.instance;
            case "assert": return voidMethod((caller, args) -> {
                if(args.get(0)== BoolClass.FALSE)
                    throw new LCLangRuntimeException("Assertion Error", "Value is false", caller);
            }, PostVMClass.OBJECT_TYPE);
            case "exit": return voidMethod((caller, args) -> System.exit(args.get(0).cast(IntClass.class).value),
                    IntClass.TYPE);
            case "sleep": return voidMethod((caller, args) -> {
                try {
                    Thread.sleep(args.get(0).cast(LongClass.class).value);
                } catch (InterruptedException e) {
                    throw new LCLangRuntimeException("Interrupted", e.getMessage(), caller);
                }
            }, LongClass.TYPE);
            case "time": return method((caller, args) -> LongClass.get(System.currentTimeMillis()/1000L),
                    LongClass.TYPE);
            case "millisTime": return method((caller, args) -> LongClass.get(System.currentTimeMillis()),
                    LongClass.TYPE);
            case "nanoTime": return method((caller, args) -> LongClass.get(System.nanoTime()),
                    LongClass.TYPE);
            case "regexMatch": return method((caller, args) -> {
                String stringPattern = args.get(0).cast(StringClass.class).string;
                Pattern pattern;

                if(cachePattern.containsKey(stringPattern)) pattern = cachePattern.get(stringPattern);
                else {
                    pattern = Pattern.compile(stringPattern);
                    cachePattern.put(stringPattern, pattern);
                }

                Matcher matcher = pattern.matcher(args.get(1).cast(StringClass.class).string);
                if(!matcher.find()) return BoolClass.FALSE;

                List<PostVMClass> classes = new ArrayList<>();
                classes.add(StringClass.get(matcher.group(0)));
                for (int i = 0; i < matcher.groupCount(); i++) {
                    String group = matcher.group(i + 1);
                    PostVMClass clazz = NullClass.INSTANCE;
                    if(group!=null) clazz = StringClass.get(group);

                    classes.add(clazz);
                }

                return new ArrayClass(classes);
            }, StringClass.type, StringClass.type, ArrayClass.type);
        }

        return super.loadGlobal(target);
    }

    public static class StdClass extends LibraryClass {
        public static final StdClass instance = new StdClass();

        private StdClass() {
            super("std");
            executor.variables.put("output", new OutputClass(System.out));
            executor.variables.put("input", new InputClass(System.in));
        }

        @Override
        public PostVMClass loadGlobal(String target) {
            switch (target) {
                case "getClassesCount": return method((caller, args) ->
                        IntClass.get(PostVMClass.classesCount), IntClass.TYPE);
                case "getProperty": return method((caller, args) ->
                        StringClass.get(System.getProperty(args.get(0).toString(caller))), StringClass.type);
            }
            return super.loadGlobal(target);
        }
    }
}
