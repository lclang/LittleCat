package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.exceptions.TypeErrorException;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Type;
import lclang.utils.TypeUtils;

import java.util.ArrayList;
import java.util.List;

public class CallExpression extends Expression {
    public final Expression expression;
    public final List<Expression> arguments;

    public CallExpression(Expression expression, List<Expression> arguments, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.arguments = arguments;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Caller expressionCaller = expression.getCaller(prevCaller);
        Value value = expression.visit(prevCaller, visitor);
        if(!(value.type instanceof CallableType))
            throw new TypeErrorException("Value is not callable (it is "+value.type+")", expressionCaller);

        ArrayList<Type> argsTypes = new ArrayList<>();
        ArrayList<Value> args = new ArrayList<>();
        for(Expression argument: arguments) {
            Value argumentValue = argument.visit(prevCaller, visitor);
            argsTypes.add(argumentValue.type);

            args.add(argumentValue);
        }

        Method method = (Method) value.get.invoke(expressionCaller);
        if(method.args.length!=argsTypes.size()){
            throw method.args.length>argsTypes.size() ?
                    new TypeErrorException("Invalid arguments: few arguments",
                            getCaller(prevCaller)):
                    new TypeErrorException("Invalid arguments: too many arguments",
                            arguments.get(method.args.length).getCaller(prevCaller));
        }

        int notAcceptArg = TypeUtils.isAccept(method.args, argsTypes.toArray(new Type[0]));
        if(notAcceptArg!=-1)
            throw new TypeErrorException("Invalid argument "+notAcceptArg+
                    ": excepted "+method.args[notAcceptArg], arguments.get(notAcceptArg).getCaller(prevCaller));

        return method.call(getCaller(prevCaller), args);
    }
}
