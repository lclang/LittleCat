package lclang.statements.expressions;

import lclang.statements.Statement;

public abstract class Expression extends Statement {
    public Expression(int line, int column) {
        super(line, column);
    }
}
