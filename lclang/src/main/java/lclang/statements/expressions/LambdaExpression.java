package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.methods.MethodImpl;
import lclang.statements.MethodStatement;
import lclang.statements.TypeStatement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LambdaExpression extends Expression {
    public final List<MethodStatement.Argument> args;
    public final TypeStatement returnType;
    public final Expression expression;

    public LambdaExpression(List<MethodStatement.Argument> args,
                            TypeStatement returnType,
                            Expression expression,
                            int line) {
        super(line);
        this.args = args;
        this.returnType = returnType;
        this.expression = expression;
    }

    @NotNull
    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return new MethodImpl(visitor, args,
                returnType.toType(visitor.root), expression, true).asValue();
    }
}
