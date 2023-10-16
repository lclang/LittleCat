// Generated from /home/levkopo/IdeaProjects/LittleCat/lclang/src/main/java/lclang/lclang.g4 by ANTLR 4.13.1
package lclang;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lclangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lclangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lclangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(lclangParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(lclangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#primaryType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryType(lclangParser.PrimaryTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(lclangParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#namedType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedType(lclangParser.NamedTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#unionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionType(lclangParser.UnionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(lclangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(lclangParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(lclangParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#parentnesesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentnesesExpr(lclangParser.ParentnesesExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#returnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpr(lclangParser.ReturnExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#typeGet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeGet(lclangParser.TypeGetContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(lclangParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#stop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStop(lclangParser.StopContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(lclangParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(lclangParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#container}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer(lclangParser.ContainerContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(lclangParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#newClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(lclangParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(lclangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(lclangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(lclangParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(lclangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(lclangParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#classExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExpr(lclangParser.ClassExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#extendsArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsArgs(lclangParser.ExtendsArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(lclangParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(lclangParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(lclangParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#use}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse(lclangParser.UseContext ctx);
	/**
	 * Visit a parse tree produced by {@link lclangParser#global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal(lclangParser.GlobalContext ctx);
}