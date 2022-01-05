package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangClassNotFoundException;
import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;

public class GetClassConstructorExpression extends Expression {
    public final String name;

    public GetClassConstructorExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        PostVMClass clazz = visitor.root.getClass(name);
        if(clazz!=null) {
            if(clazz.constructor==null)
                throw new LCLangConstructorNotFoundException(getCaller(prevCaller));

            return clazz.constructor.createLink();
        }

        throw new LCLangClassNotFoundException(name, getCaller(prevCaller));
    }
}
