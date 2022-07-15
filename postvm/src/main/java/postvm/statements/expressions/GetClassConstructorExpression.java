package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangClassNotFoundException;
import postvm.exceptions.LCLangConstructorNotFoundException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.library.classes.VoidClass;

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
            Integer constructor = clazz.getConstructor();
            if(constructor==null)
                return VoidClass.value;

            return new Link(constructor);
        }

        throw new LCLangClassNotFoundException(name, getCaller(prevCaller));
    }
}
