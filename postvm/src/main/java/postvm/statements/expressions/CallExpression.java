package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.TypeUtils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.PostVMClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

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
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Caller expressionCaller = expression.getCaller(prevCaller);
        PostVMClass callClazz = expression.visit(prevCaller, visitor).get(expressionCaller);
        if(!(callClazz.classType instanceof CallableType))
            throw new LCLangTypeErrorException("Value is not callable (it is "+callClazz.classType+")", expressionCaller);

        ArrayList<Type> argsTypes = new ArrayList<>();
        ArrayList<PostVMClass> args = new ArrayList<>();
        for(Expression argument: arguments) {
            Link argumentValue = argument.visit(prevCaller, visitor);
            PostVMClass clazz = argumentValue.get(expression.getCaller(prevCaller));
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