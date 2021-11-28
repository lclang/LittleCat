package lclang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caller {
    public final LCRootExecutor root;
    public final int line;
    public final Caller prevCaller;

    public Caller(LCRootExecutor root, int line, Caller prevCaller) {
        this.root = root;
        this.line = line;
        this.prevCaller = prevCaller;
    }

    public Caller(LCRootExecutor root, int line) {
        this(root, line, null);
    }

    @Override
    public String toString() {
        return "at "+root.path+":"+line+"";
    }

    public List<Caller> toList() {
        List<Caller> callers = new ArrayList<>();
        if(prevCaller!=null) {
            callers.addAll(prevCaller.toList());
        }

        if(prevCaller==null||prevCaller.line!=line)
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
