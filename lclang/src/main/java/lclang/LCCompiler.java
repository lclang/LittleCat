package lclang;

import org.antlr.v4.runtime.tree.ParseTree;
import postvm.PostVMRoot;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.DoubleClass;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.LongClass;
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
        return new VariableExpression(ctx.getText(), ctx.getStart().getLine());
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
        PostVMClass lcClass;
        String text = ctx.getText();
        if (ctx.STRING() != null)
            lcClass = StringClass.get(Utils.unescapeString(text.substring(1, text.length() - 1)));
        else if (ctx.CHAR() != null)
            lcClass = CharClass.get(Utils.unescapeString(text).charAt(1));
        else if (ctx.DOUBLE() != null)
            lcClass = DoubleClass.get(Double.parseDouble(text));
        else if (ctx.INTEGER() != null)
            lcClass = IntClass.get(Integer.parseInt(text));
        else if (ctx.LONG() != null)
            lcClass = LongClass.get(Long.parseLong(text));
        else if (ctx.HEX_LONG() != null)
            lcClass = LongClass.get(Long.parseLong(text, 16));
        else if (ctx.BOOL() != null)
            lcClass = BoolClass.get(text.length() == 4);
        else throw new RuntimeException();

        return new ValueExpression(lcClass);
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
        List<Expression> expressions = new ArrayList<>();
        for (lclangParser.ExpressionContext expression: ctx.expression()) {
            expressions.add(visitExpression(expression));
        }

        return new ArrayExpression(expressions);
    }

    @Override
    public Statement visitReturnExpr(lclangParser.ReturnExprContext ctx) {
        Expression returnExpression = null;
        lclangParser.ExpressionContext expressionContext = ctx.expression();
        if(expressionContext!=null)
            returnExpression = visitExpression(expressionContext);

        return new ReturnExpression(returnExpression);
    }

    @Override
    public Statement visitTypeGet(lclangParser.TypeGetContext ctx) {
        return new GetTypeExpression(
                visitExpression(ctx.expression())
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
        return new StopExpression(ctx.getStart().getLine());
    }

    @Override
    public Expression visitExpression(lclangParser.ExpressionContext ctx) {
        lclangParser.PrimitiveContext primitiveContext = ctx.primitive();
        if(primitiveContext!=null) return visitPrimitive(primitiveContext);

        List<lclangParser.ExpressionContext> expressionContexts = ctx.expression();
        List<Expression> expressions = new ArrayList<>();
        for (lclangParser.ExpressionContext expressionContext: expressionContexts)
            expressions.add(visitExpression(expressionContext));

        if(ctx.call!=null) {
            Expression callable = expressions.get(0);
            expressions.remove(0);

            return new CallExpression(
                    callable,
                    expressions,
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
            UnaryOperationExpression.Operation operation = null;
            if(ctx.unaryPlus!=null)
                operation = UnaryOperationExpression.Operation.UNARY_PLUS;
            else if(ctx.unaryMinus!=null)
                operation = UnaryOperationExpression.Operation.UNARY_MINUS;
            else if(ctx.not!=null)
                operation = UnaryOperationExpression.Operation.NOT;
            else if(ctx.throwNull!=null)
                operation = UnaryOperationExpression.Operation.NULL_CHECK;
            else if(ctx.arrayAccess!=null)
                operation = UnaryOperationExpression.Operation.ARRAY_ACCESS;

            return new UnaryOperationExpression(
                    expressions.get(0),
                    operation,
                    ctx.getStart().getLine()
            );
        }

        BinaryOperationExpression.Operation operation = null;
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
        else if(ctx.and!=null)
            operation = BinaryOperationExpression.Operation.ADD;
        else if(ctx.arrayAccess!=null)
            operation = BinaryOperationExpression.Operation.ARRAY_ACCESS;
        else if(ctx.nullableOr!=null)
            operation = BinaryOperationExpression.Operation.NULLABLE_OR;

        if(ctx.assign!=null) {
            Expression setExpression = expressions.get(1);
            if(operation!=null)
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
    public Statement visitLambda(lclangParser.LambdaContext ctx) {
        lclangParser.TypeContext returnTypeCtx = ctx.type();
        TypeStatement returnType = MagicTypeStatement.VOID;
        if(returnTypeCtx!=null)
            returnType = getType(returnTypeCtx);

        return new LambdaExpression(
                getArguments(ctx.arg()),
                returnType,
                visitExpression(ctx.expression()),
                ctx.getStart().getLine()
        );
    }

    public List<MethodStatement.Argument> getArguments(List<lclangParser.ArgContext> argsCtx) {
       List<MethodStatement.Argument> args = new ArrayList<>();
        for (lclangParser.ArgContext argCtx: argsCtx) {
            TypeStatement type = MagicTypeStatement.ANY;
            lclangParser.TypeContext typeContext = argCtx.type();
            if(typeContext!=null)
                type = getType(typeContext);

            args.add(new MethodStatement.Argument(argCtx.ID().getText(), type));
        }

        return args;
    }

    public void fillFile(PostVMRoot root, lclangParser.FileContext ctx) throws LCLangRuntimeException {
        root.globals.put("null", NullClass.instance);

        List<PostVMRoot> libraries = new ArrayList<>();
        libraries.addAll(Global.libraries);
        libraries.addAll(Global.javaLibraries);

        for (PostVMRoot library: libraries) {
            root.accept(library);
        }

        root.statements.clear();
        List<lclangParser.StmtContext> statementsCtx = ctx.stmt();
        for(lclangParser.StmtContext stmtContext: statementsCtx)
            root.statements.add(visitStmt(stmtContext));

        List<lclangParser.GlobalContext> globalsCtx = ctx.global();
        for(lclangParser.GlobalContext globalContext: globalsCtx)
            root.globals.put(
                    globalContext.ID().getText(),
                    visitValue(globalContext.value()).value
            );

        List<lclangParser.ClassExprContext> classExprContexts = ctx.classExpr();
        for(lclangParser.ClassExprContext classExprContext: classExprContexts)
            getClass(classExprContext).visit(root);

        List<lclangParser.MethodContext> methodContexts = ctx.method();
        for(lclangParser.MethodContext methodContext: methodContexts)
            getMethod(methodContext).visit(root, false);
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
        List<Expression> extendsArguments = new ArrayList<>();
        if(ctx.classExtends!=null) {
            extendsClass = getNamedType(ctx.classExtends);
            if(ctx.extendsArgs()!=null)
                for (lclangParser.ExpressionContext expressionContext: ctx.extendsArgs().expression())
                    extendsArguments.add(visitExpression(expressionContext));
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
        TypeStatement returnType = MagicTypeStatement.VOID;
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

        return new CallableTypeStatement(typeStatements,
                returnType,
                typeContext.getStart().getLine()
        );
    }
}
