package postvm;

import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;

import java.util.List;

public abstract class Library extends LibraryClass {
    public Library(String name) {
        super(null, new PostVMClassPrototype(name + "_library", PostVMClass.PROTOTYPE, Utils.listOf()) {
            @Override
            public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
                throw new LCLangConstructorNotFoundException(caller);
            }
        });
    }
}
