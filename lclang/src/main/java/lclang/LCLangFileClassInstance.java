package lclang;

import postvm.Caller;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.methods.MethodInstance;

import java.io.File;
import java.util.*;

public class LCLangFileClassInstance extends PostVMClassInstance {
    public static final String SCRIPT_CLASS_NAME = "__script";
    public static final String MAIN_METHOD_NAME = "__main";

    public final HashMap<String, Integer> globals = new HashMap<>();

    public final static PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            SCRIPT_CLASS_NAME,
            ObjectClassInstance.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new LCLangFileClassInstance(
                    new File(
                            PostVMClassInstance.instances.get(Caller.instances.get(caller).root).path
                    )
            ).classId;
        }
    };

    private final File file;

    public LCLangFileClassInstance(File file) {
        super(0, PROTOTYPE, file.getAbsolutePath(), new int[0]);
        this.file = file;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "null":
                return NullClassInstance.INSTANCE.classId;
            case "__PATH__":
                return StringClassInstance.get(file.getPath());
            case "__DIR__":
                return StringClassInstance.get(file.getParent());
        }

        if (globals.containsKey(target))
            return globals.get(target);

        return super.loadMethod(clazz, target);
    }


    public void execute(List<Integer> args) throws LCLangRuntimeException {
        ((MethodInstance) PostVMClassInstance.instances.get(globals.get(MAIN_METHOD_NAME))).call(
                Caller.register(classId, 0, 0),
                new int[]{
                        new ArrayClassInstance(args).classId
                }
        );
    }
}
