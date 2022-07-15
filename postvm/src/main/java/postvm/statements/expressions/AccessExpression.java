package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.Opcodes;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangNullPointerException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class AccessExpression extends Expression {
    public final Expression expression;
    public final VariableExpression variable;

    public AccessExpression(Expression expression, VariableExpression variable, int line) {
        super(line);
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Link clazzLink = expression.visit(caller, visitor);
        if(clazzLink.state!=Link.State.NOTHING) return clazzLink;

        return variable.visit(caller, clazzLink.get().executor);
    }

    @Override
    public void compile(List<Integer> bytes, Caller prevCaller) {
        expression.compile(bytes, getCaller(prevCaller));
        bytes.add(Opcodes.GET_FIELD);
        bytes.addAll(compileBytes(variable.name.getBytes(StandardCharsets.UTF_8)));
    }
}
