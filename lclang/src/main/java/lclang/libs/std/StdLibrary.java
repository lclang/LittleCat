package lclang.libs.std;

import lclang.Global;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.Library;
import lclang.libs.lang.classes.*;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.LongClass;
import lclang.libs.std.classes.*;
import lclang.types.Types;

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

        globals.put("LC_VERSION", StringClass.get(Global.version));
        globals.put("LC_BUILD", IntClass.get(Global.buildTime));
        globals.put("std", StdClass.instance);
        globals.put("assert", voidMethod((caller, args) -> {
            if(args.get(0)==BoolClass.FALSE)
                throw new LCLangRuntimeException("Assertion Error", "Value is false", caller);
        }, Types.ANY));

        globals.put("exit", voidMethod((caller, args) -> System.exit(args.get(0).cast(IntClass.class).value),
                IntClass.TYPE));
        globals.put("sleep", voidMethod((caller, args) -> {
                    try {
                        Thread.sleep(args.get(0).cast(LongClass.class).value);
                    } catch (InterruptedException e) {
                        throw new LCLangRuntimeException("Interrupted", e.getMessage(), caller);
                    }
                }, LongClass.TYPE));

        globals.put("time", voidMethod((caller, args) -> LongClass.get(System.currentTimeMillis()/1000L),
                LongClass.TYPE));
        globals.put("millisTime", voidMethod((caller, args) -> LongClass.get(System.currentTimeMillis()),
                LongClass.TYPE));
        globals.put("nanoTime", voidMethod((caller, args) -> LongClass.get(System.nanoTime()),
                LongClass.TYPE));
        globals.put("regexMatch", method((caller, args) -> {
            String stringPattern = args.get(0).cast(StringClass.class).string;
            Pattern pattern;

            if(cachePattern.containsKey(stringPattern)) pattern = cachePattern.get(stringPattern);
            else {
                pattern = Pattern.compile(stringPattern);
                cachePattern.put(stringPattern, pattern);
            }

            Matcher matcher = pattern.matcher(args.get(1).cast(StringClass.class).string);
            if(!matcher.find()) return BoolClass.FALSE;

            List<LCClass> classes = new ArrayList<>();
            classes.add(StringClass.get(matcher.group(0)));
            for (int i = 0; i < matcher.groupCount(); i++) {
                String group = matcher.group(i + 1);
                LCClass clazz = NullClass.instance;
                if(group!=null) clazz = StringClass.get(group);

                classes.add(clazz);
            }

            return new ArrayClass(classes);
        }, StringClass.type, StringClass.type, ArrayClass.type));
    }

    public static class StdClass extends LibraryClass {
        public static final StdClass instance = new StdClass();

        private StdClass() {
            super("std");
            executor.variables.put("output", new OutputClass(System.out));
            executor.variables.put("input", new InputClass(System.in));
            globals.put("getClassesCount", method((caller, args) -> IntClass.get(LCClass.classesCount), IntClass.TYPE));
            globals.put("getProperty", method((caller, args) ->
                    StringClass.get(System.getProperty(args.get(0).toString(caller))), StringClass.type));
        }
    }
}
