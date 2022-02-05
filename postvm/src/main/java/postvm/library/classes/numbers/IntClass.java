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

public final class IntClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "int",
            NumberClass.PROTOTYPE,
            Utils.listOf(PostVMClass.OBJECT_TYPE)
    ){

        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            try {
                return IntClass.get(Integer.parseInt(args.get(0).toString(caller)));
            } catch (NumberFormatException e) {
                throw new LCLangIOException("Invalid number format "+e.getMessage().toLowerCase(), caller);
            }
        }
    };

    public static final Type TYPE = PROTOTYPE.type;
    public int value;

    private IntClass(int value) {
        super(null, PROTOTYPE);
        this.value = value;
        this.extendsClass.cast(NumberClass.class).value = value;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toBinary": return method((caller, lcClasses) ->
                            StringClass.get(Integer.toBinaryString(value)),
                    StringClass.type);
        }

        return super.loadGlobal(target);
    }

    public static IntClass get(int value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (IntClass) CacheManager.cashedClasses.get(value);

        IntClass intClass = new IntClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
