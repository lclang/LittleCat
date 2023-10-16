package postvm;

import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.library.classes.LibraryClassInstance;
import postvm.library.classes.ObjectClassInstance;
import postvm.classes.PostVMClassPrototype;

public abstract class Library extends LibraryClassInstance {
    public Library(String name) {
        super(Caller.CALLER_NONE, new PostVMClassPrototype(name + "_library", ObjectClassInstance.PROTOTYPE, Utils.listOf()) {
            @Override
            public int createClass(int caller, int[] args) {
                throw new LCLangConstructorNotFoundException(caller);
            }
        });
    }
}
