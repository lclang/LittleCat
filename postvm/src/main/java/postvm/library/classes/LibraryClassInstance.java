package postvm.library.classes;

import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;

public abstract class LibraryClassInstance extends PostVMClassInstance {
    public LibraryClassInstance(int caller, PostVMClassPrototype prototype) {
        super(caller, prototype, new int[0]);
    }

    public LibraryClassInstance(int caller, PostVMClassPrototype prototype, int[] extendsArgs) {
        super(caller, prototype, extendsArgs);
    }
}
