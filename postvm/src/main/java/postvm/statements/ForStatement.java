package postvm.statements;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.statements.expressions.Expression;

public class ForStatement extends Statement {
    public final Expression value;
    public final Expression values;
    public final Statement statement;

    public ForStatement(Expression value, Expression values, Statement statement) {
        super(0);
        this.value = value;
        this.values = values;
        this.statement = statement;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        PostVMClassInstance clazz = values.visit(prevCaller, visitor).get();
        if(!clazz.prototype.canCast(ArrayClassInstance.PROTOTYPE))
            throw new LCLangTypeErrorException("Expected array", prevCaller);

        ArrayClassInstance array = (ArrayClassInstance) clazz;
        for (int i = 0; i < array.value.size(); i++) {
            value.visit(prevCaller, visitor).set(prevCaller, array.get(0));
            Link value = statement.visit(prevCaller, visitor);
            if(value.state== Link.State.RETURN)
                return value;
            else if(value.state== Link.State.STOP)
                break;
        }

        return null;
    }
}
