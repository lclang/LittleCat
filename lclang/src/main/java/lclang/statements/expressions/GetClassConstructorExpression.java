package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangClassNotFoundException;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.LCClass;

public class GetClassConstructorExpression extends Expression {
    public final String name;

    public GetClassConstructorExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        LCClass clazz = visitor.root.classes.get(name);
        if(clazz!=null)
            return clazz.constructor.createLink();

        throw new LCLangClassNotFoundException(name, getCaller(prevCaller));
    }
}
