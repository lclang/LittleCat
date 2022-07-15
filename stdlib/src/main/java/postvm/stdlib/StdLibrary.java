package postvm.stdlib;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Library;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.NumberClass;
import postvm.stdlib.classes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdLibrary extends Library {
    public static final Map<String, Pattern> cachePattern = new HashMap<>();
    public static final StdLibrary INSTANCE = new StdLibrary();

    private StdLibrary() {
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
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "std": return StdClass.instance;
            case "assert": return voidNativeMethod((caller, args) -> {
                if(args[0]==BoolClass.FALSE)
                    throw new LCLangRuntimeException("Assertion Error", "Value is false", caller);
            }, ObjectClass.OBJECT_TYPE);
            case "exit": return voidMethod((caller, args) -> System.exit(args[0].cast(NumberClass.class).value.intValue()),
                    NumberClass.TYPE);
            case "sleep": return voidMethod((caller, args) -> {
                try {
                    Thread.sleep(args[0].cast(NumberClass.class).value.longValue());
                } catch (InterruptedException e) {
                    throw new LCLangRuntimeException("Interrupted", e.getMessage(), caller);
                }
            }, NumberClass.TYPE);
            case "time": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(System.currentTimeMillis()/1000L));
            case "millisTime": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(System.currentTimeMillis()));
            case "nanoTime": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(System.nanoTime()));
            case "regexMatch": return method(ArrayClass.type, (caller, args) -> {
                String stringPattern = args[0].cast(StringClass.class).string;
                Pattern pattern;

                if(cachePattern.containsKey(stringPattern)) pattern = cachePattern.get(stringPattern);
                else {
                    pattern = Pattern.compile(stringPattern);
                    cachePattern.put(stringPattern, pattern);
                }

                Matcher matcher = pattern.matcher(args[1].cast(StringClass.class).string);
                if(!matcher.find()) return BoolClass.FALSE;

                List<Integer> classes = new ArrayList<>();
                classes.add(StringClass.get(matcher.group(0)));
                for (int i = 0; i < matcher.groupCount(); i++) {
                    String group = matcher.group(i + 1);
                    int value = NullClass.INSTANCE.classId;
                    if(group!=null) value = StringClass.get(group);

                    classes.add(value);
                }

                return new ArrayClass(classes).classId;
            }, StringClass.type, StringClass.type);
        }

        return super.loadGlobal(clazz, target);
    }

    public static class StdClass extends LibraryClass {
        public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
                "std", ObjectClass.PROTOTYPE, Utils.listOf()
        ) {
            @Override
            public int createClass(Caller caller, int[] args) {
                return instance;
            }
        };

        public static final int instance = new StdClass().classId;

        private StdClass() {
            super(null, PROTOTYPE);
            executor.variables.put("output", new OutputClass(new Caller(this, 0), System.out).classId);
            executor.variables.put("input", new InputClass(new Caller(this, 0), System.in).classId);
        }

        @Override
        public Integer loadGlobal(PostVMClass clazz, String target) {
            switch (target) {
                case "getClassesCount": return method(NumberClass.TYPE, (caller, args) ->
                        NumberClass.get(PostVMClass.instances.size()));
                case "getCacheCount": return method(NumberClass.TYPE, (caller, args) ->
                        NumberClass.get(CacheManager.cashedClasses.size()));
                case "gc": return voidNativeMethod((caller, args) -> CacheManager.clearCache());
                case "getProperty": return method(StringClass.type, (caller, args) ->
                        StringClass.get(System.getProperty(args[0].toString(caller))));
            }
            return super.loadGlobal(clazz, target);
        }
    }
}
