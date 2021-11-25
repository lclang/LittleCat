package lclang;

import lclang.exceptions.LCLangException;
import lclang.exceptions.VariableNotFoundException;
import lclang.types.Types;

import java.util.HashMap;

public class LCBaseExecutor {
    public final LCRootExecutor root;
    public final HashMap<String, Value> variables = new HashMap<>();

    public LCBaseExecutor(LCRootExecutor root) {
        this.root = root;
    }

    public LCBaseExecutor(LCBaseExecutor executor, boolean importVariables) {
        this(executor.root);
        if(importVariables) variables.putAll(executor.variables);
    }

    public Value getLink(Caller c, String name) throws LCLangException {
        Value value = new Value(Types.UNDEFINED, caller -> {
            throw new VariableNotFoundException(name, caller);
        }, Value.State.NOTHING);

        if(variables.containsKey(name))
            value = variables.get(name);
        else {
            Value link = root.getLink(c, name);
            if(link!=null) value = link;
        }

        value.set = (caller, newValue) -> variables.put(name, newValue);

        return value;
    }
}
