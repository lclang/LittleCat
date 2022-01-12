package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;

import java.util.HashMap;
import java.util.WeakHashMap;

public class PostVMExecutor {
    public final PostVMClass root;
    public PostVMExecutor parentExecutor = null;
    public final WeakHashMap<String, PostVMClass> variables = new WeakHashMap<>();

    public PostVMExecutor(PostVMClass root) {
        this.root = root;
    }

    public PostVMExecutor(PostVMExecutor executor, boolean importVariables) {
        this(executor.root);
        if(importVariables) parentExecutor = executor;
    }

    public Link getVariableClass(Caller caller, String name) {
        PostVMClass clazz;
        if(variables.containsKey(name)){
            clazz = variables.getOrDefault(name, null);
        } else {
            if(parentExecutor!=null) {
                Link link = parentExecutor.getVariableClass(caller, name);
                if(link != VoidClass.value) return link;
            }

            Link link = root.getVariableClass(caller, name);
            if(link != VoidClass.value) return link;
            else clazz = VoidClass.INSTANCE;
        }

        return new Link(Link.State.NOTHING) {
            @Override
            public PostVMClass get(Caller caller) throws LCLangRuntimeException {
                return clazz;
            }

            @Override
            public void set(Caller caller, PostVMClass value) throws LCLangRuntimeException {
                variables.put(name, value);
            }
        };
    }
}
