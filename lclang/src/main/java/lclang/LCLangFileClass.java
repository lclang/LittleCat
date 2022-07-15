package lclang;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.methods.Method;

import java.io.File;
import java.util.*;

public class LCLangFileClass extends PostVMClass {
    public static final String SCRIPT_CLASS_NAME = "__script";
    public static final String MAIN_METHOD_NAME = "__main";

    public final HashMap<String, Integer> globals = new HashMap<>();

    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            SCRIPT_CLASS_NAME,
            ObjectClass.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            return new LCLangFileClass(new File(caller.root.path)).classId;
        }
    };

    private final File file;

    public LCLangFileClass(File file) {
        super(null, PROTOTYPE, file.getAbsolutePath(), new int[0]);
        this.file = file;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "null": return NullClass.INSTANCE.classId;
            case "__PATH__": return StringClass.get(file.getPath());
            case "__DIR__": return StringClass.get(file.getParent());
        }

        if(globals.containsKey(target))
            return globals.get(target);

        return super.loadGlobal(clazz, target);
    }


    public void execute(List<Integer> args) throws LCLangRuntimeException {
        ((Method) PostVMClass.instances.get(globals.get(MAIN_METHOD_NAME))).call(new Caller(this, 0), new int[] {
                new ArrayClass(args).classId
        });
    }
}
