package lclang.libs.lang.classes.numbers;

import lclang.Global;
import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;
import lclang.types.Types;

public class LongClass extends NumberClass {
    public static final String NAME = "long";
    public static final LongClass INSTANCE = new LongClass();
    public static final Type TYPE = INSTANCE.classType;
    public long value;

    private LongClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> LongClass.get(
                Long.parseLong(lcClasses.get(0).toString(caller))), Types.ANY, TYPE);
    }

    private LongClass(long value) {
        super(NAME, value);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toBinary", method((caller, lcClasses) -> StringClass.get(Long.toBinaryString(value)),
                StringClass.type));
    }

    public static LongClass get(long value) {
        if(Global.cashedClasses.containsKey(value))
            return (LongClass) Global.cashedClasses.get(value);

        LongClass intClass = new LongClass(value);
        Global.saveCache(value, intClass);
        return intClass;
    }
}
