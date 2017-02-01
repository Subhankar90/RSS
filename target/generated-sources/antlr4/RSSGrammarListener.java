// Generated from RSSGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RSSGrammarParser}.
 */
public interface RSSGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(RSSGrammarParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(RSSGrammarParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#container}.
	 * @param ctx the parse tree
	 */
	void enterContainer(RSSGrammarParser.ContainerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#container}.
	 * @param ctx the parse tree
	 */
	void exitContainer(RSSGrammarParser.ContainerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(RSSGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(RSSGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(RSSGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(RSSGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link RSSGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(RSSGrammarParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link RSSGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(RSSGrammarParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link RSSGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(RSSGrammarParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link RSSGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(RSSGrammarParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(RSSGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(RSSGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(RSSGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(RSSGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(RSSGrammarParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(RSSGrammarParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(RSSGrammarParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(RSSGrammarParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(RSSGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(RSSGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#returnDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterReturnDeclaration(RSSGrammarParser.ReturnDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#returnDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitReturnDeclaration(RSSGrammarParser.ReturnDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(RSSGrammarParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(RSSGrammarParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(RSSGrammarParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(RSSGrammarParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(RSSGrammarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(RSSGrammarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(RSSGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(RSSGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RSSGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(RSSGrammarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RSSGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(RSSGrammarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(RSSGrammarParser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(RSSGrammarParser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtExpression(RSSGrammarParser.GtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtExpression(RSSGrammarParser.GtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqExpression(RSSGrammarParser.NotEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqExpression(RSSGrammarParser.NotEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(RSSGrammarParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(RSSGrammarParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(RSSGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(RSSGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModulusExpression(RSSGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModulusExpression(RSSGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(RSSGrammarParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(RSSGrammarParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtEqExpression(RSSGrammarParser.GtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtEqExpression(RSSGrammarParser.GtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpression(RSSGrammarParser.DivideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpression(RSSGrammarParser.DivideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(RSSGrammarParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(RSSGrammarParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(RSSGrammarParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(RSSGrammarParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(RSSGrammarParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(RSSGrammarParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(RSSGrammarParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(RSSGrammarParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(RSSGrammarParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(RSSGrammarParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(RSSGrammarParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(RSSGrammarParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpression(RSSGrammarParser.SubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpression(RSSGrammarParser.SubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(RSSGrammarParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(RSSGrammarParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtEqExpression(RSSGrammarParser.LtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link RSSGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtEqExpression(RSSGrammarParser.LtEqExpressionContext ctx);
}