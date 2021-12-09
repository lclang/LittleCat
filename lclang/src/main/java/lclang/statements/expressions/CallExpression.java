package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
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
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Caller expressionCaller = expression.getCaller(prevCaller);
        LCClass callClazz = expression.visit(prevCaller, visitor).get.invoke(expressionCaller);
        if(!(callClazz.classType instanceof CallableType))
            throw new LCLangTypeErrorException("Value is not callable (it is "+callClazz.classType+")", expressionCaller);

        ArrayList<Type> argsTypes = new ArrayList<>();
        ArrayList<LCClass> args = new ArrayList<>();
        for(Expression argument: arguments) {
            Link argumentValue = argument.visit(prevCaller, visitor);
            LCClass clazz = argumentValue.get.invoke(expression.getCaller(prevCaller));
            argsTypes.add(clazz.classType);
            args.add(clazz);
        }

        Method method = (Method) callClazz;
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

        return method.call(getCaller(prevCaller), args).createLink();
    }
}
