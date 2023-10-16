package postvm.statements;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Statement {
    public final int line;

    public Statement(int line) {
        this.line = line;
    }

    public abstract Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException;

    public int getCaller(int caller) {
        return Caller.register(Caller.ROOT_BY_PREV, line, caller);
    }

    public static List<Integer> compileBytes(byte[] bytes) {
        List<Integer> list = new ArrayList<>();
        for (byte b: bytes) {
            list.add((int) b);
        }

        return list;
    }

    public void compile(List<Integer> bytes, int prevCaller) {};
}
