package postvm;

import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.statements.Statement;
import postvm.utils.Function0;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostVMRoot extends PostVMClass {
    public final ArrayList<Statement> statements = new ArrayList<>();
    public final HashMap<String, Function0<PostVMClass>> globals = new HashMap<>();

    public PostVMRoot(File file) {
        super(null, new PostVMClassPrototype("file", PostVMClass.PROTOTYPE, Utils.listOf()) {
            @Override
            public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
                throw new LCLangConstructorNotFoundException(caller);
            }
        }, file.getAbsolutePath(), Utils.listOf());
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        if(target.equals("null")) return NullClass.INSTANCE;
        else if(globals.containsKey(target))
            return globals.get(target).invoke();

        return super.loadGlobal(target);
    }

    public PostVMClass execute() throws LCLangRuntimeException {
        for (Statement statement: statements) {
            Caller caller = new Caller(this, statement.line);
            Link value = statement.visit(caller, executor);

            PostVMClass clazz = value.get(caller);
            if(value.state!= Link.State.NOTHING)
                return clazz;
        }

        return NullClass.INSTANCE;
    }
}
