package postvm.statements.expressions;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.TypeUtils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.classes.PostVMClassInstance;
import postvm.methods.MethodInstance;
import postvm.types.Type;

import java.util.List;

public class CallExpression extends Expression {
    public final Expression expression;
    public final Expression[] arguments;

    public CallExpression(Expression expression, Expression[] arguments, int line) {
        super(line);
        this.expression = expression;
        this.arguments = arguments;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        int expressionCaller = expression.getCaller(prevCaller);
        PostVMClassInstance callClazz = expression.visit(prevCaller, visitor).get();
        if(!callClazz.prototype.canCast(MethodInstance.PROTOTYPE))
            throw new LCLangTypeErrorException("Value is not callable (it is "+callClazz.prototype.name+")", expressionCaller);

        Type[] argsTypes = new Type[arguments.length];
        int[] args = new int[argsTypes.length];

        for (int i = 0, l = argsTypes.length; i < l; i++) {
            Expression argument = arguments[i];

            Link argumentValue = argument.visit(prevCaller, visitor);
            if(argumentValue.state!=Link.State.NOTHING) return argumentValue;

            PostVMClassInstance clazz = argumentValue.get();
            argsTypes[i] = clazz.prototype.type;
            args[i] = clazz.classId;
        }

        MethodInstance method = (MethodInstance) callClazz;

        int notAcceptArg = TypeUtils.isAccept(method.args, argsTypes);
        if(notAcceptArg!=-1) {
            if(method.args.length!=argsTypes.length){
                throw method.args.length>argsTypes.length ?
                        new LCLangTypeErrorException("Invalid arguments: few arguments",
                                getCaller(prevCaller)):
                        new LCLangTypeErrorException("Invalid arguments: too many arguments",
                                arguments[method.args.length].getCaller(prevCaller));
            }

            throw new LCLangTypeErrorException("Invalid argument " + (notAcceptArg + 1) +
                    ": excepted " + method.args[notAcceptArg] + ", but received " + argsTypes[notAcceptArg],
                    arguments[notAcceptArg].getCaller(prevCaller));
        }

        return new Link(method.call(getCaller(prevCaller), args));
    }

    @Override
    public void compile(List<Integer> bytes, int prevCaller) {
        super.compile(bytes, prevCaller);
    }
}
