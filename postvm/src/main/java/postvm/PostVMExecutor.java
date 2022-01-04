package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;

import java.util.HashMap;

public class PostVMExecutor {
    public final PostVMRoot root;
    public final HashMap<String, PostVMClass> variables = new HashMap<>();

    public PostVMExecutor(PostVMRoot root) {
        this.root = root;
    }

    public PostVMExecutor(PostVMExecutor executor, boolean importVariables) {
        this(executor.root);
        if(importVariables) variables.putAll(executor.variables);
    }

    public PostVMClass getVariableClass(Caller caller, String name) {
        PostVMClass clazz = variables.getOrDefault(name, null);
        if(clazz==null) return root.getVariableClass(caller, name);

        return clazz;
    }

    public Link getLink(String name) {
        return new Link(Link.State.NOTHING) {
            @Override
            public PostVMClass get(Caller caller) throws LCLangRuntimeException {
                PostVMClass clazz = getVariableClass(caller, name);
                if(clazz!=null) return clazz;
                return VoidClass.INSTANCE;
            }

            @Override
            public void set(Caller caller, PostVMClass value) throws LCLangRuntimeException {
                variables.put(name, value);
            }
        };
    }
}
