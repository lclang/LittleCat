package lclang.statements;

import lclang.LCRootExecutor;
import lclang.types.Type;

public class MagicTypeStatement extends TypeStatement {
    public final Type type;

    public MagicTypeStatement(Type type) {
        super(0);
        this.type = type;
    }

    @Override
    public Type toType(LCRootExecutor root) {
        return type;
    }
}
