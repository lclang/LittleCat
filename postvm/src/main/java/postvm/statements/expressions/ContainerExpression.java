package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.VoidClass;
import postvm.statements.Statement;

public class ContainerExpression extends Expression {
    private final Statement[] statements;

    public ContainerExpression(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        for(Statement stmt: statements) {
            Caller caller = stmt.getCaller(prevCaller);
            Link value = stmt.visit(caller, visitor);
            if(value.state!= Link.State.NOTHING) {
                if(value.state == Link.State.RETURN)
                    value.state = Link.State.NOTHING;

                return value;
            }else value.get(caller);
        }

        return VoidClass.value;
    }
}
