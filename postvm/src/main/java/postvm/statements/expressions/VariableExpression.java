package postvm.statements.expressions;

import postvm.*;
import postvm.exceptions.LCLangRuntimeException;

import java.util.List;

public class VariableExpression extends Expression {
    public final String name;

    private VariableExpression(String name) {
        super(0);
        this.name = name;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        return visitor.getVariableClass(name);
    }

    @Override
    public void compile(List<Integer> bytes, Caller prevCaller) {
        bytes.add(Opcodes.GET);
//        bytes.add(Opcodes.STR);
        bytes.addAll(compileBytes(name.getBytes()));
//        bytes.add(Opcodes.STR);
    }

    public static VariableExpression get(String name) {
        if(CacheManager.cacheExpression.containsKey("variable-" + name))
            return (VariableExpression) CacheManager.cacheExpression.get("variable-" + name);

        VariableExpression expression = new VariableExpression(name);
        CacheManager.cacheExpression.put("variable-" + name, expression);

        return expression;
    }
}
