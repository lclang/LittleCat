package postvm.library.classes;

import postvm.Caller;

import java.util.Collections;
import java.util.List;

public abstract class LibraryClass extends PostVMClass {
    public LibraryClass(Caller caller, PostVMClassPrototype prototype) {
        super(caller, prototype, new Integer[0]);
    }

    public LibraryClass(Caller caller, PostVMClassPrototype prototype, Integer[] extendsArgs) {
        super(caller, prototype, extendsArgs);
    }
}
