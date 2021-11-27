package lclang.statements;

import lclang.LCRootExecutor;
import lclang.types.Type;
import lclang.types.Types;

public class MagicTypeStatement extends TypeStatement {
    public static final MagicTypeStatement ANY = new MagicTypeStatement(Types.ANY);
    public static final MagicTypeStatement VOID = new MagicTypeStatement(Types.VOID);
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
