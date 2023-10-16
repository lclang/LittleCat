package postvm.stdlib;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Library;
import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;
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
        classes.put("SocketServer", SocketServerClassInstance.PROTOTYPE);
        classes.put("Socket", SocketClassInstance.PROTOTYPE);
//        classes.put("SSLSocket", SSLSocketClass.instance);
        classes.put("Output", OutputClassInstance.PROTOTYPE);
        classes.put("Input", InputClassInstance.PROTOTYPE);
        classes.put("File", FileClassInstance.PROTOTYPE);
        classes.put("Math", MathClassInstance.PROTOTYPE);
        classes.put("Thread", ThreadClassInstance.PROTOTYPE);
        classes.put("std", StdClassInstance.PROTOTYPE);
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "std": return StdClassInstance.instance;
            case "assert": return voidNativeMethod((caller, args) -> {
                if(args[0]== BoolClassInstance.FALSE)
                    throw new LCLangRuntimeException("Assertion Error", "Value is false", caller);
            }, ObjectClassInstance.OBJECT_TYPE);
            case "exit": return voidMethod((caller, args) -> System.exit(args[0].cast(NumberClassInstance.class).value.intValue()),
                    NumberClassInstance.TYPE);
            case "sleep": return voidMethod((caller, args) -> {
                try {
                    Thread.sleep(args[0].cast(NumberClassInstance.class).value.longValue());
                } catch (InterruptedException e) {
                    throw new LCLangRuntimeException("Interrupted", e.getMessage(), caller);
                }
            }, NumberClassInstance.TYPE);
            case "time": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(System.currentTimeMillis()/1000L));
            case "millisTime": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(System.currentTimeMillis()));
            case "nanoTime": return method(NumberClassInstance.TYPE, (caller, args) -> NumberClassInstance.get(System.nanoTime()));
            case "regexMatch": return method(ArrayClassInstance.type, (caller, args) -> {
                String stringPattern = args[0].cast(StringClassInstance.class).string;
                Pattern pattern;

                if(cachePattern.containsKey(stringPattern)) pattern = cachePattern.get(stringPattern);
                else {
                    pattern = Pattern.compile(stringPattern);
                    cachePattern.put(stringPattern, pattern);
                }

                Matcher matcher = pattern.matcher(args[1].cast(StringClassInstance.class).string);
                if(!matcher.find()) return BoolClassInstance.FALSE;

                List<Integer> classes = new ArrayList<>();
                classes.add(StringClassInstance.get(matcher.group(0)));
                for (int i = 0; i < matcher.groupCount(); i++) {
                    String group = matcher.group(i + 1);
                    int value = NullClassInstance.INSTANCE.classId;
                    if(group!=null) value = StringClassInstance.get(group);

                    classes.add(value);
                }

                return new ArrayClassInstance(classes).classId;
            }, StringClassInstance.type, StringClassInstance.type);
        }

        return super.loadMethod(clazz, target);
    }

    public static class StdClassInstance extends LibraryClassInstance {
        public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
                "std", ObjectClassInstance.PROTOTYPE, Utils.listOf()
        ) {
            @Override
            public int createClass(int caller, int[] args) {
                return instance;
            }
        };

        public static final int instance = new StdClassInstance().classId;

        private StdClassInstance() {
            super(Caller.CALLER_NONE, PROTOTYPE);
            executor.variables.put("output", new OutputClassInstance(Caller.CALLER_NONE, System.out).classId);
            executor.variables.put("input", new InputClassInstance(Caller.CALLER_NONE, System.in).classId);
        }

        @Override
        public Integer loadMethod(PostVMClassInstance clazz, String target) {
            switch (target) {
                case "getClassesCount": return method(NumberClassInstance.TYPE, (caller, args) ->
                        NumberClassInstance.get(PostVMClassInstance.instances.size()));
                case "getCacheCount": return method(NumberClassInstance.TYPE, (caller, args) ->
                        NumberClassInstance.get(CacheManager.cashedClasses.size()));
                case "gc": return voidNativeMethod((caller, args) -> CacheManager.clearCache());
                case "getProperty": return method(StringClassInstance.type, (caller, args) ->
                        StringClassInstance.get(System.getProperty(args[0].toString(caller))));
            }
            return super.loadMethod(clazz, target);
        }
    }
}
