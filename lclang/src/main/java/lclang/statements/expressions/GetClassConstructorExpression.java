package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangClassNotFoundException;
import lclang.exceptions.LCLangRuntimeException;
import org.jetbrains.annotations.NotNull;

public class GetClassConstructorExpression extends Expression {
    public final String name;

    public GetClassConstructorExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @NotNull
    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        LCClass clazz = visitor.root.classes.get(name);
        if(clazz!=null)
            return clazz.constructor.asValue();

        throw new LCLangClassNotFoundException(name, getCaller(prevCaller));
    }
}
