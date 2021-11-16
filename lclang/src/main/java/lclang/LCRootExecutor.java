package lclang;

import lclang.exceptions.LCLangException;
import lclang.statements.Statement;

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

    public LCClass execute() throws LCLangException {
        for (Statement statement: statements) {
            Caller caller = new Caller(this, statement.line, statement.column);
            Value value = statement.visit(caller, executor);

            LCClass clazz = value.get.invoke(null);
            if(value.state!=Value.State.NOTHING)
                return clazz;
        }

        return null;
    }
}
