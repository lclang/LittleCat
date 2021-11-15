package lclang;

import lclang.exceptions.VariableNotFoundException;
import lclang.types.Types;

import java.util.HashMap;

public class LCBaseExecutor {
    public final LCRootExecutor root;
    public final HashMap<String, Value> variables = new HashMap<>();

    public LCBaseExecutor(LCRootExecutor root) {
        this.root = root;
    }

    public LCBaseExecutor(LCBaseExecutor executor) {
        this(executor.root);
    }

    public Value getLink(String name) {
        Value value = new Value(Types.UNDEFINED, caller -> {
            throw new VariableNotFoundException(name, caller);
        }, Value.State.NOTHING);

        if(variables.containsKey(name))
            value = variables.get(name);
        else if(root.globals.containsKey(name))
            value = root.globals.get(name);

        value.set = (caller, newValue) -> variables.put(name, newValue);

        return value;
    }
}
