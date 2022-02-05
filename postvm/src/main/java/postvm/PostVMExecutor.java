package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;

import java.util.HashMap;

public class PostVMExecutor {
    public final PostVMClass root;
    public PostVMExecutor parentExecutor = null;
    public final HashMap<String, PostVMClass> variables = new HashMap<>();

    public PostVMExecutor(PostVMClass root) {
        this.root = root;
    }

    public PostVMExecutor(PostVMExecutor executor, boolean importVariables) {
        this(executor.root);
        if(importVariables) parentExecutor = executor;
    }

    public Link getVariableClass(Caller caller, String name) {
        PostVMClass clazz = variables.getOrDefault(name, null);
        if(clazz==null){
            if(parentExecutor!=null) {
                Link link = parentExecutor.getVariableClass(caller, name);
                if(link != VoidClass.value) return link;
            }

            clazz = root.getVariableClass(caller, name);
        }

        return new ClassLink(clazz, Link.State.NOTHING) {
            @Override
            public void set(Caller caller, PostVMClass value) throws LCLangRuntimeException {
                variables.put(name, value);
            }
        };
    }
}
