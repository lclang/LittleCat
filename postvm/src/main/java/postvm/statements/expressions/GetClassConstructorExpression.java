package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangClassNotFoundException;
import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;

public class GetClassConstructorExpression extends Expression {
    public final String name;

    public GetClassConstructorExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        PostVMClassPrototype clazz = visitor.root.getClass(name);
        if(clazz!=null) {
            if(clazz.getConstructor()==null)
                throw new LCLangConstructorNotFoundException(getCaller(prevCaller));

            return clazz.getConstructor().createLink();
        }

        throw new LCLangClassNotFoundException(name, getCaller(prevCaller));
    }
}
