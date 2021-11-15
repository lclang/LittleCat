package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.methods.MethodImpl;
import lclang.statements.TypeStatement;
import lclang.types.Type;

import java.util.HashMap;
import java.util.Map;

public class LambdaExpression extends Expression {
    public final Map<String, TypeStatement> args;
    public final TypeStatement returnType;
    public final Expression expression;

    public LambdaExpression(Map<String, TypeStatement> args,
                            TypeStatement returnType,
                            Expression expression,
                            int line, int column) {
        super(line, column);
        this.args = args;
        this.returnType = returnType;
        this.expression = expression;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Map<String, Type> argsResolved = new HashMap<>();
        for(Map.Entry<String, TypeStatement> arg: args.entrySet())
            argsResolved.put(arg.getKey(), arg.getValue().toType(prevCaller));

        return new MethodImpl(visitor, argsResolved,
                returnType.toType(prevCaller), expression).asValue();
    }
}
