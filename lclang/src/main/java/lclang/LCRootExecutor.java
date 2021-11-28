package lclang;

import lclang.exceptions.LCLangRuntimeException;
import lclang.statements.Statement;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class LCRootExecutor {
    public final String path;
    public final LCBaseExecutor executor = new LCBaseExecutor(this);
    public final HashMap<String, Value> globals = new HashMap<>();
    public final HashMap<String, LCClass> classes = new HashMap<>();
    public final ArrayList<Statement> statements = new ArrayList<>();

    public LCRootExecutor(String path) {
        this.path = path;
    }

    public void accept(LCRootExecutor root) {
        classes.putAll(root.classes);
        globals.putAll(root.globals);
    }

    @Nullable public Value getLink(Caller caller, String name) throws LCLangRuntimeException {
        return globals.getOrDefault(name, null);
    }

    public LCClass execute() throws LCLangRuntimeException {
        for (Statement statement: statements) {
            Caller caller = statement.getCaller(this);
            Value value = statement.visit(caller, executor);

            LCClass clazz = value.get.invoke(caller);
            if(value.state!=Value.State.NOTHING)
                return clazz;
        }

        return null;
    }
}
