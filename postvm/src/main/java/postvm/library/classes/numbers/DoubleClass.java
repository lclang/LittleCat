package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.library.classes.StringClass;
import postvm.methods.Method;
import postvm.types.Type;

import java.util.List;

public final class DoubleClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "double",
            NumberClass.PROTOTYPE,
            Utils.listOf(PostVMClass.PROTOTYPE.type)
    ){

        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            try {
                return DoubleClass.get(Double.parseDouble(args.get(0).toString(caller)));
            } catch (NumberFormatException e) {
                throw new LCLangIOException("Invalid number format "+e.getMessage().toLowerCase(), caller);
            }
        }
    };

    public static final Type TYPE = PROTOTYPE.type;
    public double value;


    private DoubleClass(double value) {
        super(null, PROTOTYPE);
        this.value = value;
        this.extendsClass.cast(NumberClass.class).value = value;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toBinary": return method((caller, lcClasses) ->
                            StringClass.get(Long.toBinaryString((long) value)),
                    StringClass.type);
            case "toHex": return method((caller, lcClasses) ->
                            StringClass.get(Double.toHexString(value)),
                    StringClass.type);
        }

        return super.loadGlobal(target);
    }

    public static DoubleClass get(double value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (DoubleClass) CacheManager.cashedClasses.get(value);

        DoubleClass intClass = new DoubleClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
