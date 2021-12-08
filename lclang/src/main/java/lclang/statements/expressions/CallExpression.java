package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.LCClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Type;
import lclang.utils.TypeUtils;

import java.util.ArrayList;
import java.util.List;

public class CallExpression extends Expression {
    public final Expression expression;
    public final List<Expression> arguments;

    public CallExpression(Expression expression, List<Expression> arguments, int line) {
        super(line);
        this.expression = expression;
        this.arguments = arguments;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Caller expressionCaller = expression.getCaller(prevCaller);
        Value value = expression.visit(prevCaller, visitor);
        if(!(value.type instanceof CallableType))
            throw new LCLangTypeErrorException("Value is not callable (it is "+value.type+")", expressionCaller);

        ArrayList<Type> argsTypes = new ArrayList<>();
        ArrayList<LCClass> args = new ArrayList<>();
        for(Expression argument: arguments) {
            Value argumentValue = argument.visit(prevCaller, visitor);
            argsTypes.add(argumentValue.type);

            args.add(argumentValue.get.invoke(expression.getCaller(prevCaller)));
        }

        Method method = (Method) value.get.invoke(expressionCaller);
        if(method.args.size()!=argsTypes.size()){
            throw method.args.size()>argsTypes.size() ?
                    new LCLangTypeErrorException("Invalid arguments: few arguments",
                            getCaller(prevCaller)):
                    new LCLangTypeErrorException("Invalid arguments: too many arguments",
                            arguments.get(method.args.size()).getCaller(prevCaller));
        }

        int notAcceptArg = TypeUtils.isAccept(method.args, argsTypes);
        if(notAcceptArg!=-1)
            throw new LCLangTypeErrorException("Invalid argument "+(notAcceptArg+1)+
                    ": excepted "+method.args.get(notAcceptArg)+", but received "+argsTypes.get(notAcceptArg),
                    arguments.get(notAcceptArg).getCaller(prevCaller));

        return method.call(getCaller(prevCaller), args).asValue();
    }
}
