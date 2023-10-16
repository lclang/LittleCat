package postvm;

import postvm.classes.PostVMClassInstance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caller {
    public static final int CALLER_NONE = 0;
    public static final int ROOT_BY_PREV = -1;

    public static ArrayDeque<Integer> reuseIds = new ArrayDeque<>();
    public final static List<Caller> instances = new ArrayList<>();
    public static int lastInstanceId = 0;
    public final int instance = reuseIds.peek() != null ? reuseIds.pop(): lastInstanceId++;

    public final int root;
    public final int line;
    public final int prevCaller;

    private Caller(int root, int line, int prevCaller) {
        this.root = root;
        this.line = line;
        this.prevCaller = prevCaller;
    }
    public static int register(int root, int line, int prevCaller) {
        int rootClassId = root == ROOT_BY_PREV ? Caller.instances.get(prevCaller).root : root;

        Caller caller = new Caller(rootClassId, line, prevCaller);
        if(caller.instance < instances.size()-1) {
            instances.set(caller.instance, caller);
        }else{
            instances.add(caller);
        }

        return caller.instance;
    }

    public static void unregister(int instance) {
        reuseIds.add(instance);
        instances.set(instance, null);
    }

    @Override
    public String toString() {
        return "at "+ PostVMClassInstance.instances.get(root).path+":"+line;
    }

    public List<Caller> toList() {
        List<Caller> callers = new ArrayList<>();

        Caller prevCallerInstance = prevCaller == 0 ? null: instances.get(prevCaller);
        if(prevCallerInstance != null) {
            callers.addAll(prevCallerInstance.toList());
        }

        if(prevCallerInstance == null || prevCallerInstance.line!=line)
            callers.add(this);

        return callers;
    }

    public List<String> toStacktrace() {
        List<String> stacktrace = new ArrayList<>();
        List<Caller> callers = toList();
        Collections.reverse(callers);

        for (Caller caller: callers)
            stacktrace.add(caller.toString());

        return stacktrace;
    }
}
