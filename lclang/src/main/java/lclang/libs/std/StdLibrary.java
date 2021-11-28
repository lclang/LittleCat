package lclang.libs.std;

import lclang.Global;
import lclang.LCClass;
import lclang.Value;
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
        classes.put("Socket", SocketClass.instance);
        classes.put("Output", OutputClass.instance);
        classes.put("Input", InputClass.instance);
        classes.put("File", FileClass.instance);
        classes.put("Math", MathClass.instance);
        classes.put("Thread", ThreadClass.instance);
        classes.put("std", StdClass.instance);

        globals.put("LC_VERSION", StringClass.get(Global.version).asValue());
        globals.put("LC_BUILD", IntClass.get(Global.buildTime).asValue());
        globals.put("std", StdClass.instance.asValue());
        globals.put("assert", voidMethod((caller, args) -> {
            if(args.get(0).equals(BoolClass.FALSE))
                throw new LCLangRuntimeException("Assertion Error", "Value is false", caller);
        }, Types.ANY).asValue());

        globals.put("exit", voidMethod((caller, args) -> System.exit(((IntClass) args.get(0)).value),
                IntClass.type).asValue());
        globals.put("sleep", voidMethod((caller, args) -> {
                    try {
                        Thread.sleep(((LongClass) args.get(0)).value);
                    } catch (InterruptedException e) {
                        throw new LCLangRuntimeException("Interrupted", e.getMessage(), caller);
                    }
                }, LongClass.type).asValue());

        globals.put("time", voidMethod((caller, args) -> LongClass.get(System.currentTimeMillis()/1000L),
                LongClass.type).asValue());
        globals.put("millisTime", voidMethod((caller, args) -> LongClass.get(System.currentTimeMillis()),
                LongClass.type).asValue());
        globals.put("nanoTime", voidMethod((caller, args) -> LongClass.get(System.nanoTime()),
                LongClass.type).asValue());
        globals.put("regexMatch", method((caller, args) -> {
            String stringPattern = args.get(0).toString(caller);
            Pattern pattern;

            if(cachePattern.containsKey(stringPattern)) pattern = cachePattern.get(stringPattern);
            else {
                pattern = Pattern.compile(stringPattern);
                cachePattern.put(stringPattern, pattern);
            }

            Matcher matcher = pattern.matcher(args.get(1).toString(caller));
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
        }, StringClass.type, StringClass.type, ArrayClass.type).asValue());
    }

    public static class StdClass extends LibraryClass {
        public static final StdClass instance = new StdClass();

        private StdClass() {
            super("std");
            executor.variables.put("output", new OutputClass(System.out).asValue());
            executor.variables.put("input", new InputClass(System.in).asValue());
            globals.put("classesCount", new Value(IntClass.type, caller -> IntClass.get(LCClass.classesCount)));
            globals.put("getProperty", method((caller, lcClasses) ->
                    StringClass.get(System.getProperty(lcClasses.get(0).toString(caller))), StringClass.type).asValue());
        }
    }
}
