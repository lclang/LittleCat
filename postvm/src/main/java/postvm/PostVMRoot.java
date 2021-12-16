package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;
import postvm.statements.Statement;

import java.util.ArrayList;
import java.util.HashMap;

public class PostVMRoot {
    public final String path;
    public final PostVMExecutor executor = new PostVMExecutor(this);
    public final HashMap<String, PostVMClass> globals = new HashMap<>();
    public final HashMap<String, PostVMClass> classes = new HashMap<>();
    public final ArrayList<Statement> statements = new ArrayList<>();

    public PostVMRoot(String path) {
        this.path = path;
    }

    public void accept(PostVMRoot root) {
        classes.putAll(root.classes);
        globals.putAll(root.globals);
    }

    public PostVMClass getVariableClass(Caller caller, String name) throws LCLangRuntimeException {
        PostVMClass clazz = globals.getOrDefault(name, null);
        if(clazz==null) return executor.getVariableClass(caller, name);
        return clazz;
    }

    public PostVMClass execute() throws LCLangRuntimeException {
        for (Statement statement: statements) {
            Caller caller = statement.getCaller(this);
            Link value = statement.visit(caller, executor);

            PostVMClass clazz = value.get(caller);
            if(value.state!= Link.State.NOTHING)
                return clazz;
        }

        return NullClass.instance;
    }
}
