package lclang;

import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangVariableNotFoundException;
import lclang.libs.lang.classes.LCClass;
import lclang.types.Types;

import java.util.HashMap;

public class LCBaseExecutor {
    public final LCRootExecutor root;
    public final HashMap<String, LCClass> variables = new HashMap<>();

    public LCBaseExecutor(LCRootExecutor root) {
        this.root = root;
    }

    public LCBaseExecutor(LCBaseExecutor executor, boolean importVariables) {
        this(executor.root);
        if(importVariables) variables.putAll(executor.variables);
    }

    public Value getLink(Caller c, String name) throws LCLangRuntimeException {
        
        Value value;
        if(variables.containsKey(name))
            value = variables.get(name).asValue();
        else {
            Value link = root.getLink(c, name);
            if(link!=null) value = link;
            else value = new Value(Types.UNDEFINED, caller -> {
                throw new LCLangVariableNotFoundException(name, caller);
            }, Value.State.NOTHING);
        }

        value.set = (caller, clazz) -> variables.put(name, clazz);

        return value;
    }
}
