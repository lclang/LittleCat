package postvm;

import postvm.exceptions.LCLangRuntimeException;
import postvm.classes.PostVMClassInstance;
import postvm.library.classes.VoidClassInstance;

import java.util.HashMap;

public class PostVMExecutor {
    public final PostVMClassInstance root;
    public PostVMExecutor parentExecutor = null;
    public final HashMap<String, Integer> variables = new HashMap<>();

    public PostVMExecutor(PostVMClassInstance root) {
        this.root = root;
    }

    public PostVMExecutor(PostVMExecutor executor, boolean importVariables) {
        this(executor.root);
        if(importVariables) parentExecutor = executor;
    }

    public Link getVariableClass(String name) {
        Integer classId = VoidClassInstance.INSTANCE.classId;
        if(!variables.containsKey(name)){
            if(parentExecutor!=null) {
                return parentExecutor.getVariableClass(name);
            }

            Integer global = root.getGlobal(name);
            if(global!=null) classId = global;
            else if(root.getExtendsClass()!=null) return root.getExtendsClass().executor.getVariableClass(name);
        }else{
            classId = variables.get(name);
        }

        return new ExecutorLink(name,this, classId, Link.State.NOTHING);
    }

    public final static class ExecutorLink extends Link {
        public final String name;
        public final PostVMExecutor owner;

        public ExecutorLink(String name, PostVMExecutor owner, int classId, int state) {
            super(classId, state);
            this.name = name;
            this.owner = owner;
        }

        @Override
        public void set(int caller, int classId) throws LCLangRuntimeException {
            owner.variables.put(name, classId);
        }
    }
}
