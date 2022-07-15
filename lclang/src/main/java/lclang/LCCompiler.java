package lclang;

import org.antlr.v4.runtime.tree.ParseTree;
import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;
import postvm.methods.MethodImpl;
import postvm.statements.*;
import postvm.statements.expressions.*;

import java.util.ArrayList;
import java.util.List;

public class LCCompiler extends lclangBaseVisitor<Statement> {
    public static final LCCompiler instance = new LCCompiler();
    private LCCompiler() {}

    @Override
    @Deprecated
    public Statement visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public Statement visitStmt(lclangParser.StmtContext ctx) {
        return ctx.children.get(0).accept(this);
    }

    @Override
    public VariableExpression visitVariable(lclangParser.VariableContext ctx) {
        return VariableExpression.get(ctx.getText());
    }

    @Override
    public Statement visitBlock(lclangParser.BlockContext ctx) {
        Statement[] statements = new Statement[ctx.stmt().size()];
        for (int i = 0; i < statements.length; i++) {
            statements[i] = ctx.stmt().get(i).accept(this);
        }

        return new BlockStatement(statements);
    }

    @Override
    public Statement visitContainer(lclangParser.ContainerContext ctx) {
        Statement[] statements = new Statement[ctx.stmt().size()];
        for (int i = 0; i < statements.length; i++) {
            statements[i] = ctx.stmt().get(i).accept(this);
        }

        return new ContainerExpression(statements);
    }

    @Override
    public ValueExpression visitValue(lclangParser.ValueContext ctx) {

        String text = ctx.getText();
        if (ctx.STRING() != null)
            return ValueExpression.get(Utils.unescapeString(text.substring(1, text.length() - 1)));
        else if (ctx.CHAR() != null)
            return ValueExpression.get(Utils.unescapeString(text).charAt(1));
        else if (ctx.DOUBLE() != null)
            return ValueExpression.get(Double.parseDouble(text));
        else if (ctx.INTEGER() != null)
            return ValueExpression.get(Integer.parseInt(text));
        else if (ctx.LONG() != null)
            return ValueExpression.get(Long.parseLong(text));
        else if (ctx.HEX_LONG() != null)
            return ValueExpression.get(Long.parseLong(text, 16));
        else if (ctx.BOOL() != null)
            return ValueExpression.get(text.length() == 4);
        else throw new RuntimeException();
    }

    @Override
    public Statement visitWhileStmt(lclangParser.WhileStmtContext ctx) {
        Statement statement = null;
        lclangParser.StmtContext stmtCtx = ctx.stmt();
        if(stmtCtx!=null){
            statement = visitStmt(stmtCtx);
        }

        return new WhileStatement(visitExpression(ctx.expression()), statement);
    }

    @Override
    public Statement visitIfStmt(lclangParser.IfStmtContext ctx) {
        Statement ifFalse = null;
        if(ctx.ifF!=null)
            ifFalse = visitStmt(ctx.ifF);

        return new IfStatement(
                visitExpression(ctx.condition),
                visitStmt(ctx.ifT),
                ifFalse);
    }

    @Override
    public Statement visitIfExpr(lclangParser.IfExprContext ctx) {
        return new IfExpression(
                visitExpression(ctx.condition),
                visitExpression(ctx.ifT),
                visitExpression(ctx.ifF));
    }

    @Override
    public Statement visitArray(lclangParser.ArrayContext ctx) {
        List<lclangParser.ExpressionContext> expressionContexts = ctx.expression();
        Expression[] expressions = new Expression[expressionContexts.size()];

        for (int i = 0, l = expressions.length; i < l; i++) {
            expressions[i] = visitExpression(expressionContexts.get(i));
        }

        return new ArrayExpression(expressions);
    }

    @Override
    public Statement visitReturnExpr(lclangParser.ReturnExprContext ctx) {
        Expression returnExpression;
        lclangParser.ExpressionContext expressionContext = ctx.expression();
        if(expressionContext!=null)
            returnExpression = visitExpression(expressionContext);
        else returnExpression = VariableExpression.get("void");

        return new ReturnExpression(returnExpression);
    }

    @Override
    public Statement visitTypeGet(lclangParser.TypeGetContext ctx) {
        int startLine = ctx.getStart().getLine();

        return new AccessExpression(
                visitExpression(ctx.expression()),
                VariableExpression.get(PostVMClass.Constants.FIELD_TYPE),
                startLine
        );
    }

    @Override
    public Statement visitNewClass(lclangParser.NewClassContext ctx) {
        return new GetClassConstructorExpression(
                ctx.className.getText(),
                ctx.getStart().getLine()
        );
    }

    @Override
    public Expression visitPrimitive(lclangParser.PrimitiveContext ctx) {
        return (Expression) ctx.children.get(0).accept(this);
    }

    @Override
    public Statement visitStop(lclangParser.StopContext ctx) {
        return StopExpression.STOP;
    }

    @Override
    public Expression visitExpression(lclangParser.ExpressionContext ctx) {
        lclangParser.PrimitiveContext primitiveContext = ctx.primitive();
        if(primitiveContext!=null) return (Expression) ctx.children.get(0).accept(this);

        List<lclangParser.ExpressionContext> expressionContexts = ctx.expression();
        List<Expression> expressions = new ArrayList<>();
        for (lclangParser.ExpressionContext expressionContext: expressionContexts)
            expressions.add(visitExpression(expressionContext));

        if(ctx.call!=null) {
            Expression callable = expressions.get(0);
            expressions.remove(0);

            return new CallExpression(
                    callable,
                    expressions.toArray(new Expression[0]),
                    ctx.getStart().getLine()
            );
        }else if(ctx.access!=null) {
            return new AccessExpression(
                    expressions.get(0),
                    visitVariable(ctx.variable()),
                    ctx.getStart().getLine()
            );
        }else if(ctx.is!=null) {
            return new IsExpression(
                    expressions.get(0),
                    getType(ctx.type())
            );
        }else if(expressions.size()==1){
            int unaryOperation = 0;
            int binOperation = 0;

            if(ctx.unaryPlus!=null)
                binOperation = BinaryOperationExpression.Operation.ADD;
            else if(ctx.unaryMinus!=null)
                binOperation = BinaryOperationExpression.Operation.MINUS;
            else if(ctx.not!=null)
                unaryOperation = UnaryOperationExpression.Operation.NOT;
            else if(ctx.throwNull!=null)
                unaryOperation = UnaryOperationExpression.Operation.NULL_CHECK;
            else if(ctx.arrayAccess!=null)
                unaryOperation = UnaryOperationExpression.Operation.ARRAY_ACCESS;
            else if(ctx.compliment!=null)
                unaryOperation = UnaryOperationExpression.Operation.BINARY_COMPLIMENT;

            if(unaryOperation!=0) return new UnaryOperationExpression(
                    expressions.get(0),
                    unaryOperation,
                    ctx.getStart().getLine()
            );

            return new AssignExpression(expressions.get(0), new BinaryOperationExpression(
                    expressions.get(0),
                    ValueExpression.get(1),
                    binOperation,
                    ctx.getStart().getLine()
            ));
        }

        int operation = 0;
        if(ctx.add!=null)
            operation = BinaryOperationExpression.Operation.ADD;
        else if(ctx.minus!=null)
            operation = BinaryOperationExpression.Operation.MINUS;
        else if(ctx.multiplication!=null)
            operation = BinaryOperationExpression.Operation.MULTIPLICATION;
        else if(ctx.div!=null)
            operation = BinaryOperationExpression.Operation.DIVISION;
        else if(ctx.pow!=null)
            operation = BinaryOperationExpression.Operation.POW;
        else if(ctx.largerEquals!=null)
            operation = BinaryOperationExpression.Operation.LARGER_EQUALS;
        else if(ctx.larger!=null)
            operation = BinaryOperationExpression.Operation.LARGER;
        else if(ctx.lessEquals!=null)
            operation = BinaryOperationExpression.Operation.LESS_EQUALS;
        else if(ctx.less!=null)
            operation = BinaryOperationExpression.Operation.LESS;
        else if(ctx.equals!=null)
            operation = BinaryOperationExpression.Operation.EQUALS;
        else if(ctx.notEquals!=null)
            operation = BinaryOperationExpression.Operation.NOT_EQUALS;
        else if(ctx.or!=null)
            operation = BinaryOperationExpression.Operation.OR;
        else if(ctx.andBin!=null)
            operation = BinaryOperationExpression.Operation.BINARY_AND;
        else if(ctx.xor!=null)
            operation = BinaryOperationExpression.Operation.BINARY_XOR;
        else if(ctx.orBin!=null)
            operation = BinaryOperationExpression.Operation.BINARY_OR;
        else if(ctx.leftShift!=null)
            operation = BinaryOperationExpression.Operation.BINARY_LEFT_SHIFT;
        else if(ctx.rightShift!=null)
            operation = BinaryOperationExpression.Operation.BINARY_RIGHT_SHIFT;
        else if(ctx.and!=null)
            operation = BinaryOperationExpression.Operation.AND;
        else if(ctx.arrayAccess!=null)
            operation = BinaryOperationExpression.Operation.ARRAY_ACCESS;
        else if(ctx.nullableOr!=null)
            operation = BinaryOperationExpression.Operation.NULLABLE_OR;

        if(ctx.assign!=null) {
            Expression setExpression = expressions.get(1);
            if(operation!=0)
                setExpression = new BinaryOperationExpression(
                        expressions.get(0),
                        setExpression, operation,
                        ctx.getStart().getLine());

            return new AssignExpression(
                    expressions.get(0),
                    setExpression
            );
        }

        return new BinaryOperationExpression(
                expressions.get(0),
                expressions.get(1),
                operation,
                ctx.getStart().getLine()
        );
    }

    @Override
    public Expression visitParentnesesExpr(lclangParser.ParentnesesExprContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public Statement visitLambda(lclangParser.LambdaContext ctx) {
        lclangParser.TypeContext returnTypeCtx = ctx.type();
        TypeStatement returnType = NamedTypeStatement.VOID;
        if(returnTypeCtx!=null)
            returnType = getType(returnTypeCtx);

        return new LambdaExpression(
                getArguments(ctx.arg()),
                returnType,
                visitExpression(ctx.expression()),
                ctx.getStart().getLine()
        );
    }

    public MethodStatement.Argument[] getArguments(List<lclangParser.ArgContext> argsCtx) {
        MethodStatement.Argument[] args = new MethodStatement.Argument[argsCtx.size()];
        for (int i = 0, l = args.length; i < l; i++) {
            lclangParser.ArgContext argCtx = argsCtx.get(i);

            TypeStatement type = NamedTypeStatement.ANY;
            lclangParser.TypeContext typeContext = argCtx.type();
            if(typeContext!=null)
                type = getType(typeContext);

            args[i] = new MethodStatement.Argument(argCtx.ID().getText(), type);
        }

        return args;
    }

    public void fillFile(LCLangFileClass root, lclangParser.FileContext ctx) throws LCLangRuntimeException {
        root.parents.addAll(Global.javaLibraries);
        root.parents.addAll(Global.libraries);

        List<lclangParser.GlobalContext> globalsCtx = ctx.global();
        for(lclangParser.GlobalContext globalContext: globalsCtx)
            root.globals.put(
                    globalContext.ID().getText(),
                    visitValue(globalContext.value()).visit(null, root.executor).get()
            );

        List<Statement> statements = new ArrayList<>();
        List<lclangParser.StmtContext> statementsCtx = ctx.stmt();
        for(lclangParser.StmtContext stmtContext: statementsCtx)
            statements.add(visitStmt(stmtContext));

        root.globals.put(LCLangFileClass.MAIN_METHOD_NAME, new MethodImpl(root.executor, new MethodStatement.Argument[]{
                new MethodStatement.Argument("args", new NamedTypeStatement("array", 0))
        }, VoidClass.PROTOTYPE.type, new BlockStatement(statements.toArray(new Statement[0])), false));

        List<lclangParser.ClassExprContext> classExprContexts = ctx.classExpr();
        for(lclangParser.ClassExprContext classExprContext: classExprContexts)
            getClass(classExprContext).visit(root);

        List<lclangParser.MethodContext> methodContexts = ctx.method();
        for(lclangParser.MethodContext methodContext: methodContexts) {
            MethodStatement method = getMethod(methodContext);
            root.globals.put(method.name, method.visit(root, false));
        }

        System.gc();
    }

    public ClassStatement getClass(lclangParser.ClassExprContext ctx) {
        List<Statement> statements = new ArrayList<>();
        List<lclangParser.StmtContext> stmtContexts = ctx.stmt();
        for (lclangParser.StmtContext stmtContext: stmtContexts) {
            statements.add(visitStmt(stmtContext));
        }

        List<lclangParser.MethodContext> methodContexts = ctx.method();
        MethodStatement[] methodStatements = new MethodStatement[methodContexts.size()];
        for (int i = 0; i < methodStatements.length; i++) {
            methodStatements[i] = getMethod(methodContexts.get(i));
        }

        NamedTypeStatement extendsClass = null;
        Expression[] extendsArguments = new Expression[0];
        if(ctx.classExtends!=null) {
            extendsClass = getNamedType(ctx.classExtends);

            lclangParser.ExtendsArgsContext extendsArgCtx = ctx.extendsArgs();
            if(extendsArgCtx!=null) {

                List<lclangParser.ExpressionContext> expressionContexts = extendsArgCtx.expression();
                extendsArguments = new Expression[expressionContexts.size()];

                for (int i = 0, l = extendsArguments.length; i < l; i++) {
                    extendsArguments[i] = visitExpression(expressionContexts.get(i));
                }
            }
        }

        return new ClassStatement(
                ctx.name.getText(),
                extendsClass,
                getArguments(ctx.arg()),
                statements,
                extendsArguments,
                methodStatements
        );
    }

    public MethodStatement getMethod(lclangParser.MethodContext ctx) {
        lclangParser.TypeContext returnTypeCtx = ctx.type();
        TypeStatement returnType = NamedTypeStatement.VOID;
        if(returnTypeCtx!=null) returnType = getType(returnTypeCtx);

        Statement statement;
        lclangParser.ExpressionContext expressionContext = ctx.expression();
        if(expressionContext!=null)
            statement = visitExpression(expressionContext);
        else statement = visitBlock(ctx.block());

        return new MethodStatement(
                ctx.ID().getText(),
                getArguments(ctx.arg()),
                returnType, statement);
    }

    public TypeStatement getType(lclangParser.TypeContext ctx) {
        lclangParser.PrimaryTypeContext primaryTypeContext = ctx.primaryType();
        if(primaryTypeContext!=null) return getPrimaryType(primaryTypeContext);

        List<lclangParser.PrimaryTypeContext> unionTypeContext = ctx.unionType().primaryType();
        TypeStatement[] typeStatements = new TypeStatement[unionTypeContext.size()];
        for (int i = 0, l = typeStatements.length; i < l; i++) {
            typeStatements[i] = getPrimaryType(unionTypeContext.get(i));
        }

        return new UnionTypeStatement(typeStatements);
    }

    public TypeStatement getPrimaryType(lclangParser.PrimaryTypeContext ctx) {
        lclangParser.MethodTypeContext typeContext = ctx.methodType();

        TypeStatement type;
        if(typeContext!=null)
            type = getMethodType(typeContext);
        else type = getNamedType(ctx.namedType());

        type.nullable = ctx.nullable!=null;
        return type;
    }

    private NamedTypeStatement getNamedType(lclangParser.NamedTypeContext namedTypeContext) {
        return new NamedTypeStatement(
                namedTypeContext.getText(),
                namedTypeContext.getStart().getLine()
        );
    }

    private CallableTypeStatement getMethodType(lclangParser.MethodTypeContext typeContext) {
        List<lclangParser.TypeContext> typeCtxList = typeContext.type();
        TypeStatement returnType = getType(typeCtxList.get(typeCtxList.size()-1));
        typeCtxList.remove(typeCtxList.size()-1);

        List<TypeStatement> typeStatements = new ArrayList<>();
        for (lclangParser.TypeContext type: typeCtxList) {
            typeStatements.add(getType(type));
        }

        return new CallableTypeStatement(typeStatements.toArray(new TypeStatement[0]),
                returnType,
                typeContext.getStart().getLine()
        );
    }
}
