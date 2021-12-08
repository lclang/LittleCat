package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.VoidClass;
import lclang.statements.Statement;

public class ContainerExpression extends Expression {
    private final Statement[] statements;

    public ContainerExpression(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        for(Statement stmt: statements) {
            Caller caller = stmt.getCaller(prevCaller);
            Link value = stmt.visit(caller, visitor);
            if(value.state!= Link.State.NOTHING) {
                if(value.state== Link.State.RETURN)
                    value.state = Link.State.NOTHING;

                return value;
            }else value.get.invoke(caller);
        }

        return VoidClass.value;
    }
}
