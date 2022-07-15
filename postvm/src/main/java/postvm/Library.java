package postvm;

import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.ObjectClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;

import java.util.List;

public abstract class Library extends LibraryClass {
    public Library(String name) {
        super(null, new PostVMClassPrototype(name + "_library", ObjectClass.PROTOTYPE, Utils.listOf()) {
            @Override
            public int createClass(Caller caller, Integer[] args) {
                throw new LCLangConstructorNotFoundException(caller);
            }
        });
    }
}
