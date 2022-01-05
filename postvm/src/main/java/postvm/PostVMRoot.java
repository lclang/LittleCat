package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;
import postvm.statements.Statement;
import postvm.utils.Function0;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class PostVMRoot extends PostVMClass {
    public final ArrayList<Statement> statements = new ArrayList<>();
    public final HashMap<String, Function0<PostVMClass>> globals = new HashMap<>();

    public PostVMRoot(File file) {
        super("file", file.getAbsolutePath());
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        if(target.equals("null")) return NullClass.INSTANCE;
        else if(globals.containsKey(target)) return globals.get(target).invoke();

        return super.loadGlobal(target);
    }

    public PostVMClass execute() throws LCLangRuntimeException {
        for (Statement statement: statements) {
            Caller caller = statement.getCaller(this);
            Link value = statement.visit(caller, executor);

            PostVMClass clazz = value.get(caller);
            if(value.state!= Link.State.NOTHING)
                return clazz;
        }

        return NullClass.INSTANCE;
    }
}
