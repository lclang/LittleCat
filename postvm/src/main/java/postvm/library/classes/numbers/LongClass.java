package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.library.classes.StringClass;
import postvm.types.Type;

import java.util.List;

public final class LongClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "long",
            NumberClass.PROTOTYPE,
            Utils.listOf(PostVMClass.OBJECT_TYPE)
    ){
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            try {
                return LongClass.get(Long.parseLong(args.get(0).toString(caller)));
            } catch (NumberFormatException e) {
                throw new LCLangIOException("Invalid number format "+e.getMessage().toLowerCase(), caller);
            }
        }
    };

    public static final Type TYPE = PROTOTYPE.type;
    public long value;

    private LongClass(long value) {
        super(null, PROTOTYPE);
        this.value = value;
        this.extendsClass.cast(NumberClass.class).value = value;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toBinary": return method((caller, lcClasses) ->
                            StringClass.get(Long.toBinaryString(value)),
                    StringClass.type);
        }

        return super.loadGlobal(target);
    }
    public static LongClass get(long value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (LongClass) CacheManager.cashedClasses.get(value);

        LongClass intClass = new LongClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
