package lclang;

import java.util.ArrayList;
import java.util.List;

public class Caller {
    public final LCRootExecutor root;
    public final int line;
    public final int column;
    public final Caller prevCaller;

    public Caller(LCRootExecutor root, int line, int column, Caller prevCaller) {
        this.root = root;
        this.line = line;
        this.column = column;
        this.prevCaller = prevCaller;
    }

    public Caller(LCRootExecutor root, int line, int column) {
        this(root, line, column, null);
    }

    public List<Caller> toList() {
        List<Caller> callers = new ArrayList<>();
        if(prevCaller!=null) callers.addAll(prevCaller.toList());
        callers.add(this);

        return callers;
    }
}
