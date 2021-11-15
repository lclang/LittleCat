package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.ClassNotFoundException;
import lclang.exceptions.LCLangException;

public class GetClassConstructorExpression extends Expression {
    public final String name;

    public GetClassConstructorExpression(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        LCClass clazz = visitor.root.classes.get(name);
        if(clazz!=null)
            return clazz.constructor.asValue();

        throw new ClassNotFoundException(name, getCaller(prevCaller));
    }
}
