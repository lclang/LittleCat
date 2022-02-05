package postvm.stdlib;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Library;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
import postvm.methods.Method;
import postvm.stdlib.classes.*;
import postvm.types.CallableType;

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
        classes.put("SocketServer", SocketServerClass.PROTOTYPE);
        classes.put("Socket", SocketClass.PROTOTYPE);
//        classes.put("SSLSocket", SSLSocketClass.instance);
        classes.put("Output", OutputClass.PROTOTYPE);
        classes.put("Input", InputClass.PROTOTYPE);
        classes.put("File", FileClass.PROTOTYPE);
        classes.put("Math", MathClass.PROTOTYPE);
        classes.put("Thread", ThreadClass.PROTOTYPE);
        classes.put("std", StdClass.PROTOTYPE);
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
        public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
                "std", PostVMClass.PROTOTYPE, Utils.listOf()
        ) {
            @Override
            public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
                return instance;
            }
        };

        public static final StdClass instance = new StdClass();

        private StdClass() {
            super(null, PROTOTYPE);
            executor.variables.put("output", new OutputClass(new Caller(this, 0), System.out));
            executor.variables.put("input", new InputClass(new Caller(this, 0), System.in));
        }

        @Override
        public PostVMClass loadGlobal(String target) {
            switch (target) {
                case "getClassesCount": return method((caller, args) ->
                        IntClass.get(PostVMClass.classesCount), IntClass.TYPE);
                case "getCacheCount": return method((caller, args) ->
                        IntClass.get(CacheManager.cashedClasses.size()), IntClass.TYPE);
                case "gc": return voidMethod((caller, args) -> CacheManager.clearCache());
                case "getProperty": return method((caller, args) ->
                        StringClass.get(System.getProperty(args.get(0).toString(caller))), StringClass.type);
            }
            return super.loadGlobal(target);
        }
    }
}
