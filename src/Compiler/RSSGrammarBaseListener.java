package Compiler;
// Generated from RSSGrammar.g4 by ANTLR 4.5.3

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link RSSGrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class RSSGrammarBaseListener implements RSSGrammarListener {
	LinkedHashMap<String, String> variableMap = new LinkedHashMap<String, String>();
	int tempCounter = 1;
	Stack<String> tempStack = new Stack<String>();
	int ifScope = 1;
	int elseifScope = 1;
	public static  ArrayList<String> File = new ArrayList<String>();
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParse(RSSGrammarParser.ParseContext ctx) { 
		File.add("Programstart");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParse(RSSGrammarParser.ParseContext ctx) {
		//for( String str : File)
			//System.out.println(str);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterContainer(RSSGrammarParser.ContainerContext ctx) { 
		if(ctx.parent.getClass().toString().contains("$IfStatContext")) {
			if(ctx.parent.getChild(1).getChild(1).getChildCount() == 3)
				File.add("If "+ tempStack.get(tempStack.size() - 1));
		}
		if(ctx.parent.getClass().toString().contains("$IfStatContext")) {
			if(ctx.parent.getChild(1).getChild(1).getChildCount() == 1)
				if(ctx.parent.getChild(1).getChild(1).getChild(0).getChildCount() > 0)
					File.add("If _GReturn");
		}
		
		if(ctx.parent.getClass().toString().contains("$ElseIfStatContext")) {
			if(ctx.parent.getChild(2).getChild(1).getChildCount() == 3)
				File.add("Else If "+ tempStack.get(tempStack.size() - 1));
		}
		if(ctx.parent.getClass().toString().contains("$ElseIfStatContext")) {
			if(ctx.parent.getChild(2).getChild(1).getChildCount() == 1)
				if(ctx.parent.getChild(2).getChild(1).getChild(0).getChildCount() > 0)
					File.add("Else If _GReturn");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitContainer(RSSGrammarParser.ContainerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(RSSGrammarParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(RSSGrammarParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignment(RSSGrammarParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignment(RSSGrammarParser.AssignmentContext ctx) {
		int parentcount = ctx.getChildCount();
		String Statement = "SET ";
		
		switch(parentcount) {
		case 3: Statement += Utilities.getName(variableMap, ctx.getChild(0).toString(), "Local") ;
							break;
		case 4: Statement += Utilities.getName(variableMap, ctx.getChild(1).toString(), "Global") ;
							break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).toString(), "Local", null);
							break;
		case 6: if(ctx.getChild(0).toString().compareToIgnoreCase("::") != 0)		
					Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).toString(), "Local",ctx.getChild(2).toString()) ;
				else
					Statement += Utilities.getArrayName(variableMap, ctx.getChild(1).toString(), "Global", null);
				break;
		case 7: Statement += Utilities.getArrayName(variableMap, ctx.getChild(1).toString(), "Global",ctx.getChild(3).toString()) ;
				break;
		}
		
		if(ctx.getChild(parentcount - 1).getChildCount() == 1) {
			if(ctx.getChild(parentcount -1).getChild(0).getChildCount() == 0)
				Statement += " " + Utilities.getName(variableMap, ctx.getChild(parentcount - 1).getChild(0).toString(), "Local") ;
			else
				Statement += " _GReturn";
		}
		else if(ctx.getChild(parentcount - 1).getChildCount() == 2)
			Statement += " " + Utilities.getName(variableMap, ctx.getChild(parentcount - 1).getChild(1).toString(), "Global") ;
		else if(ctx.getChild(parentcount - 1).getChildCount() == 3 && ctx.getChild(parentcount - 1).getChild(0).getChildCount() == 0 && ctx.getChild(parentcount - 1).getChild(1).getChildCount() == 0)
			Statement += " " + Utilities.getArrayName(variableMap, ctx.getChild(parentcount - 1).getChild(0).toString(), "Local", null);
		else if(ctx.getChild(parentcount - 1).getChildCount() == 3 && ctx.getChild(parentcount - 1).getChild(1).getClass().toString().contains("$FunctionCallExpressionContext"))
			Statement += " _GReturn";
		else if(ctx.getChild(parentcount - 1).getChildCount() == 4)
			if(ctx.getChild(parentcount - 1).getChild(0).toString().compareToIgnoreCase("::") == 0)
				Statement += " " + Utilities.getArrayName(variableMap, ctx.getChild(parentcount - 1).getChild(1).toString(), "Global", null);
			else
				Statement += " " + Utilities.getArrayName(variableMap, ctx.getChild(parentcount - 1).getChild(0).toString(), "Local", ctx.getChild(parentcount -1).getChild(2).toString());
		else
			Statement += " " + tempStack.get(tempStack.size() - 1);
		
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIdentifierFunctionCall(RSSGrammarParser.IdentifierFunctionCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIdentifierFunctionCall(RSSGrammarParser.IdentifierFunctionCallContext ctx) { 
		File.add("Push @Pointerstack CurrentLine");
		File.add("Goto Func " + ctx.Identifier());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrintFunctionCall(RSSGrammarParser.PrintFunctionCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrintFunctionCall(RSSGrammarParser.PrintFunctionCallContext ctx) { 
		String Statement = "Print ";		
		int childcount = ctx.getChild(2).getChildCount();			
		if(childcount == 1)
			if(ctx.getChild(2).getChild(0).getChildCount() == 0)
				Statement += Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
			else
				Statement += "_GReturn";
		else if(childcount == 2)
			Statement += Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");		
		else if(childcount == 4)
			Statement += Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
		else if(childcount == 5)
			Statement += Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
		else
			Statement += tempStack.get(tempStack.size() -1);  
		
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStatement(RSSGrammarParser.IfStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfStatement(RSSGrammarParser.IfStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStat(RSSGrammarParser.IfStatContext ctx) {
		if(ctx.getChild(1).getChild(1).getChildCount() == 1) {
			if(ctx.getChild(1).getChild(1).getChild(0).getChildCount() == 0)
				File.add("If "+ Utilities.getName(variableMap, ctx.getChild(1).getChild(1).getChild(0).toString(), "Local"));
		}
		else if(ctx.getChild(1).getChild(1).getChildCount() == 2)
			File.add("If "+ Utilities.getName(variableMap, ctx.getChild(1).getChild(1).getChild(1).toString(), "Global"));		
		else if(ctx.getChild(1).getChild(1).getChildCount() == 4)
			File.add("If "+ Utilities.getArrayName(variableMap, ctx.getChild(1).getChild(1).getChild(0).toString(), "Local", ctx.getChild(1).getChild(1).getChild(2).toString()));
		else if(ctx.getChild(1).getChild(1).getChildCount() == 5)
			File.add("If "+ Utilities.getArrayName(variableMap, ctx.getChild(1).getChild(1).getChild(1).toString(), "Global", ctx.getChild(1).getChild(1).getChild(3).toString()));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfStat(RSSGrammarParser.IfStatContext ctx) { 
			File.add("Endif");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElseIfStat(RSSGrammarParser.ElseIfStatContext ctx) { 
		if(ctx.getChild(2).getChild(1).getChildCount() == 1) {
			if(ctx.getChild(2).getChild(1).getChild(0).getChildCount() == 0)
				File.add("Else If "+ Utilities.getName(variableMap, ctx.getChild(2).getChild(1).getChild(0).toString(), "Local"));
		}
		else if(ctx.getChild(2).getChild(1).getChildCount() == 2)
			File.add("Else If "+ Utilities.getName(variableMap, ctx.getChild(2).getChild(1).getChild(1).toString(), "Global"));
		else if(ctx.getChild(2).getChild(1).getChildCount() == 4)
			File.add("Else If "+ Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).getChild(0).toString(), "Local", ctx.getChild(2).getChild(1).getChild(2).toString()));
		else if(ctx.getChild(2).getChild(1).getChildCount() == 5)
			File.add("Else If "+ Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).getChild(1).toString(), "Global", ctx.getChild(2).getChild(1).getChild(3).toString()));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElseIfStat(RSSGrammarParser.ElseIfStatContext ctx) {
			File.add("Endif");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElseStat(RSSGrammarParser.ElseStatContext ctx) { 
		File.add("Else" );
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElseStat(RSSGrammarParser.ElseStatContext ctx) {
		File.add("Endelse");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionDeclaration(RSSGrammarParser.FunctionDeclarationContext ctx) {
		File.add("Func " + ctx.getChild(1).getText());}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionDeclaration(RSSGrammarParser.FunctionDeclarationContext ctx) {
		
		if(ctx.getChild(1).getText().compareToIgnoreCase("main") == 0){
			File.add("Functionend");
			File.add("Programend");
		}
		else if (ctx.getChildCount()!= 8 && ctx.getChildCount() != 9) {
			File.add("Functionend");
			File.add("POP @Pointerstack @Reg1");
			File.add("ADD @Reg1 2 @Reg1");
			File.add("Goto @Reg1");
		}
			
			
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturnDeclaration(RSSGrammarParser.ReturnDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReturnDeclaration(RSSGrammarParser.ReturnDeclarationContext ctx) { 
		String Statement;
		Statement = "SET _GReturn ";
		int childcount = ctx.getChild(1).getChildCount();			
		if(childcount == 1) {
			if(ctx.getChild(1).getChild(0).getChildCount() == 0)
				Statement += Utilities.getName(variableMap, ctx.getChild(1).getChild(0).toString(), "Local");
			else
				Statement += " _GReturn";
		}
		else if(childcount == 2)
			Statement += Utilities.getName(variableMap, ctx.getChild(1).getChild(1).toString(), "Global");	
		else if(childcount == 3 && ctx.getChild(1).getChild(0).getChildCount() == 0)
			Statement += Utilities.getArrayName(variableMap, ctx.getChild(1).getChild(0).toString(), "Local", null);
		else if(childcount == 4)
			Statement += Utilities.getArrayName(variableMap, ctx.getChild(1).getChild(0).toString(), "Local", ctx.getChild(1).getChild(2).toString());
		else if(childcount == 5)
			Statement += Utilities.getArrayName(variableMap, ctx.getChild(1).getChild(1).toString(), "Global", ctx.getChild(1).getChild(3).toString());
		else
			Statement += "_Litemp" + String.valueOf(tempCounter - 1);  
		File.add(Statement);
		File.add("Functionend");
		File.add("POP @Pointerstack @Reg1");
		File.add("ADD @Reg1 2 @Reg1");
		File.add("Goto @Reg1"); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArgList(RSSGrammarParser.ArgListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArgList(RSSGrammarParser.ArgListContext ctx) { 
		String Statement;
		int regcount =1;
		int count = ctx.getChildCount();
		int element = 0;
		while(element<count){
			int childcount = ctx.getChild(element).getChildCount();
			Statement = "SET ";
			if(childcount == 2)
				Statement += Utilities.getName(variableMap, ctx.getChild(element).getChild(1).toString(), "Local");
			else if(childcount == 4)
				Statement += Utilities.getArrayName(variableMap, ctx.getChild(element).getChild(1).toString(), "Local", null);
			else
				Statement += tempStack.get(tempStack.size() - 1);  
			Statement += " @Reg" + regcount++;
			element++;
			File.add(Statement);			
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassDeclaration(RSSGrammarParser.ClassDeclarationContext ctx) { 
		File.add("Class " + ctx.Identifier());
		File.add("Dec _GReturn");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassDeclaration(RSSGrammarParser.ClassDeclarationContext ctx) {
		File.add("Classend");}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForStatement(RSSGrammarParser.ForStatementContext ctx) { 
		File.add("Forloop");
		String Statement = "";
		switch(ctx.getChildCount()) {
			case 8: Statement+= Utilities.getName(variableMap, ctx.getChild(1).toString(), "Local");
					break;
			case 9: Statement+= Utilities.getName(variableMap, ctx.getChild(2).toString(), "Global");
					break;
			case 11: Statement+= Utilities.getArrayName(variableMap, ctx.getChild(1).toString(), "Local",ctx.getChild(3).toString());
					break;
			case 12: Statement+= Utilities.getArrayName(variableMap, ctx.getChild(2).toString(), "Global",ctx.getChild(4).toString());
					break;
		}
		
		File.add("SET " + Statement + " " + Utilities.getName(variableMap, ctx.expression(0).getChild(0).toString(), "Local"));
		tempStack.push("_LbTemp" + tempCounter);
		File.add("Dec _LbTemp" + tempCounter++);	
		File.add("LTEQ " + Statement + " " +Utilities.getName(variableMap, ctx.expression(1).getChild(0).toString(), "Local") +  " "  + tempStack.get(tempStack.size() -1));
		File.add("If " + tempStack.get(tempStack.size() - 1));
		File.add("SET @Reg1 CurrentLine");
		File.add("SUB @Reg1 2 @Reg1");
		File.add("Push @Pointerstack @Reg1");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForStatement(RSSGrammarParser.ForStatementContext ctx) {		
		if(ctx.getChildCount() == 8)
			File.add("ADD " + Utilities.getName(variableMap, ctx.getChild(1).toString(), "Local") + " 1 "+ Utilities.getName(variableMap, ctx.getChild(1).toString(), "Local"));
		else if(ctx.getChildCount() == 9)
			File.add("ADD " + Utilities.getName(variableMap, ctx.getChild(2).toString(), "Local") + " 1 "+ Utilities.getName(variableMap, ctx.getChild(2).toString(), "Global"));
		else if(ctx.getChildCount() == 11)
			File.add("ADD " + Utilities.getArrayName(variableMap, ctx.getChild(1).toString(), "Local", ctx.getChild(3).toString()) + " 1 "+ Utilities.getArrayName(variableMap, ctx.getChild(1).toString(), "Local", ctx.getChild(3).toString()));
		else if(ctx.getChildCount() == 12)
			File.add("ADD " + Utilities.getArrayName(variableMap, ctx.getChild(2).toString(), "Global", ctx.getChild(4).toString()) + " 1 "+ Utilities.getArrayName(variableMap, ctx.getChild(2).toString(), "Global", ctx.getChild(4).toString()));
		
		File.add("POP If");
		File.add("POP @Pointerstack @Reg1");
		File.add("Goto @Reg1");
		File.add("Endif");
		File.add("Else");
		File.add("Endelse");
		File.add("Endloop");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableDeclaration(RSSGrammarParser.VariableDeclarationContext ctx) {
		String parentname = "class";
		String datatypeinteger = "int";
		String datatypestring = "string";
		if(ctx.getChildCount() == 2) { 
			if(ctx.parent.parent.parent.getChild(0).toString().compareToIgnoreCase(parentname) == 0)
				if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypeinteger) == 0) {
					File.add("Dec _Gi" + ctx.Identifier(1));
					variableMap.put(ctx.Identifier(1).toString() + " Global", "Integer");
				}
				else if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypestring) == 0) {
					File.add("Dec _Gs" + ctx.Identifier(1));
					variableMap.put(ctx.Identifier(1).toString() + " Global", "String");
				}
				else {
					File.add("Dec _Gb" + ctx.Identifier(1));
					variableMap.put(ctx.Identifier(1).toString() + " Global", "Boolean");
				}
			else
				if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypeinteger) == 0) {
					File.add("Dec _Li" + ctx.Identifier(1));
					variableMap.put(ctx.Identifier(1).toString() + " Local", "Integer");
				}
				else if (ctx.Identifier(0).toString().compareToIgnoreCase(datatypestring) == 0) {
					File.add("Dec _Ls" + ctx.Identifier(1));	
					variableMap.put(ctx.Identifier(1).toString()  + " Local", "String");
				}
				else {
					File.add("Dec _Lb" + ctx.Identifier(1));	
					variableMap.put(ctx.Identifier(1).toString()  + " Local", "Boolean");
				}					
		}
		
		else if(ctx.getChildCount() == 4){
			if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypeinteger) == 0) {
				File.add("Dec _Li" + ctx.Identifier(1)+"[]");
				variableMap.put(ctx.Identifier(1).toString() + " Local Array", "Integer");
			}
			else if (ctx.Identifier(0).toString().compareToIgnoreCase(datatypestring) == 0) {
				File.add("Dec _Ls" + ctx.Identifier(1)+"[]");	
				variableMap.put(ctx.Identifier(1).toString()  + " Local Array", "String");
			}
			else {
				File.add("Dec _Lb" + ctx.Identifier(1)+"[]");	
				variableMap.put(ctx.Identifier(1).toString()  + " Local Array", "Boolean");
			}
		}
		
		
		

		else { // For Arrays
			if(ctx.parent.parent.parent.getChild(0).toString().compareToIgnoreCase(parentname) == 0) // For Global Variables
				if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypeinteger) == 0) {
					File.add("Dec _Gi" + ctx.Identifier(1) + "[] " + ctx.Number().toString());
					variableMap.put(ctx.Identifier(1).toString() + " Global Array", "Integer");
				}
				else if (ctx.Identifier(0).toString().compareToIgnoreCase(datatypestring) == 0){
					File.add("Dec _Gs" + ctx.Identifier(1) + "[] " + ctx.Number().toString());
					variableMap.put(ctx.Identifier(1).toString()  + " Global Array", "String");
				}
				else {
					File.add("Dec _Gb" + ctx.Identifier(1) + "[] " + ctx.Number().toString());
					variableMap.put(ctx.Identifier(1).toString()  + " Global Array", "Boolean");
				}
			else // For Local Variables
				if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypeinteger) == 0) {
					File.add("Dec _Li" + ctx.Identifier(1) + "[] " + ctx.Number().toString());
					variableMap.put(ctx.Identifier(1).toString()  + " Local Array", "Integer");
				}
				else if(ctx.Identifier(0).toString().compareToIgnoreCase(datatypestring) == 0){
					File.add("Dec _Ls" + ctx.Identifier(1) + "[] " + ctx.Number().toString());
					variableMap.put(ctx.Identifier(1).toString()  + " Local Array", "String");
				}
				else{
					File.add("Dec _Lb" + ctx.Identifier(1) + "[] " + ctx.Number().toString());
					variableMap.put(ctx.Identifier(1).toString()  + " Local Array", "Boolean");
				}				
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableDeclaration(RSSGrammarParser.VariableDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExprList(RSSGrammarParser.ExprListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExprList(RSSGrammarParser.ExprListContext ctx) { 
		String Statement = "";
		int regcount = 1;
		int childcount;	
		int count = ctx.getChildCount();
		int element=0;
		while(element<count){
		childcount = ctx.getChild(element).getChildCount();
		if(childcount == 1) {
			if(ctx.getChild(element).getChild(0).getChildCount() == 0)
				Statement = "SET @Reg" + regcount++ + " " + Utilities.getName(variableMap, ctx.getChild(element).getChild(0).toString(), "Local");	
			else 
				Statement = "SET @Reg" + regcount++ + " _GReturn ";			
		}
		else if(childcount == 2)
			Statement = "SET @Reg" + regcount++ + " " + Utilities.getName(variableMap, ctx.getChild(element).getChild(1).toString(), "Global");		
		else if(childcount == 3 && ctx.getChild(element).getChild(0).getChildCount() == 0)
			Statement = "SET @Reg" + regcount++ + " " + Utilities.getArrayName(variableMap, ctx.getChild(element).getChild(0).toString(), "Local", null);
		else if(childcount == 4)
			Statement = "SET @Reg" + regcount++ + " " + Utilities.getArrayName(variableMap, ctx.getChild(element).getChild(0).toString(), "Local", ctx.getChild(element).getChild(2).toString());	
		else if(childcount == 5)
			Statement = "SET @Reg" + regcount++ + " " + Utilities.getArrayName(variableMap, ctx.getChild(element).getChild(1).toString(), "Global", ctx.getChild(element).getChild(3).toString());			
		else{
			Statement = "SET @Reg" + regcount++ + " ";
			Statement += tempStack.get(tempStack.size() - 1);
		}			  
		element+=2;
		File.add(Statement);
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLtExpression(RSSGrammarParser.LtExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLtExpression(RSSGrammarParser.LtExpressionContext ctx) {
		String Statement = "LT ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " + Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " + Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterGtExpression(RSSGrammarParser.GtExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitGtExpression(RSSGrammarParser.GtExpressionContext ctx) { 
		String Statement = "GT ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNotEqExpression(RSSGrammarParser.NotEqExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNotEqExpression(RSSGrammarParser.NotEqExpressionContext ctx) { 
		String Statement = "NQ ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNumberExpression(RSSGrammarParser.NumberExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNumberExpression(RSSGrammarParser.NumberExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIdentifierExpression(RSSGrammarParser.IdentifierExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIdentifierExpression(RSSGrammarParser.IdentifierExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterModulusExpression(RSSGrammarParser.ModulusExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitModulusExpression(RSSGrammarParser.ModulusExpressionContext ctx) { 
		String Statement = "MOD ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Litemp" + String.valueOf(tempCounter));
		tempStack.push("_Litemp" + String.valueOf(tempCounter));
		Statement += " _Litemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMultiplyExpression(RSSGrammarParser.MultiplyExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMultiplyExpression(RSSGrammarParser.MultiplyExpressionContext ctx) { 
		String Statement = "MUL ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Litemp" + String.valueOf(tempCounter));
		tempStack.push("_Litemp" + String.valueOf(tempCounter));
		Statement += " _Litemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterGtEqExpression(RSSGrammarParser.GtEqExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitGtEqExpression(RSSGrammarParser.GtEqExpressionContext ctx) { 
		String Statement = "GTEQ ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDivideExpression(RSSGrammarParser.DivideExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDivideExpression(RSSGrammarParser.DivideExpressionContext ctx) {
		String Statement = "DIV ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Litemp" + String.valueOf(tempCounter));
		tempStack.push("_Litemp" + String.valueOf(tempCounter));
		Statement += " _Litemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOrExpression(RSSGrammarParser.OrExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOrExpression(RSSGrammarParser.OrExpressionContext ctx) { 
		String Statement = "OR ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEqExpression(RSSGrammarParser.EqExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEqExpression(RSSGrammarParser.EqExpressionContext ctx) {
		String Statement = "EQ ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAndExpression(RSSGrammarParser.AndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAndExpression(RSSGrammarParser.AndExpressionContext ctx) { 
		String Statement = "AND ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStringExpression(RSSGrammarParser.StringExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStringExpression(RSSGrammarParser.StringExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionExpression(RSSGrammarParser.ExpressionExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressionExpression(RSSGrammarParser.ExpressionExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAddExpression(RSSGrammarParser.AddExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAddExpression(RSSGrammarParser.AddExpressionContext ctx) {		
		String Statement = "ADD ";
		boolean tempused = false;
		boolean Stringflag1 = false;
		boolean Stringflag2 = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0) {
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
					Stringflag1= Utilities.StringCheck(variableMap,ctx.getChild(0).getChild(0).toString(), "Local", false);
				  }
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				Stringflag1= Utilities.StringCheck(variableMap, ctx.getChild(0).getChild(1).toString(), "Global",false);
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4) {
					Statement += tempStack.get(tempStack.size() - 2);
					Stringflag1= Utilities.StringCheckTemp(tempStack.get(tempStack.size() - 2));
				}
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					Stringflag1= Utilities.StringCheckTemp(tempStack.get(tempStack.size() - 1));
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				Stringflag1 = Utilities.StringCheck(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", true);
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				Stringflag1 = Utilities.StringCheck(variableMap, ctx.getChild(0).getChild(0).toString(), "Global", true);
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 Stringflag1= Utilities.StringCheckTemp(tempStack.get(tempStack.size() - 1));
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0) {
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
					Stringflag2 = Utilities.StringCheck(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", false);
					}
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				Stringflag2 = Utilities.StringCheck(variableMap, ctx.getChild(2).getChild(1).toString(), "Global",false);
				break;
		case 3:  if (tempused) {
					Statement += " " + tempStack.get(tempStack.size() - 2);
					Stringflag2= Utilities.StringCheckTemp(tempStack.get(tempStack.size() - 2));
				}
				else {
					Statement += " " + tempStack.get(tempStack.size() - 1);
					Stringflag2= Utilities.StringCheckTemp(tempStack.get(tempStack.size() - 1));
					}
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				Stringflag2 = Utilities.StringCheck(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", true);
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				Stringflag2 = Utilities.StringCheck(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", true);
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 Stringflag2= Utilities.StringCheckTemp(tempStack.get(tempStack.size() - 1));
				 break;
		}
		
		if(Stringflag1 || Stringflag2) {
			File.add("Dec _Lstemp" + String.valueOf(tempCounter));
			tempStack.push("_Lstemp" + String.valueOf(tempCounter));
			Statement += " _Lstemp" + String.valueOf(tempCounter++);
		}
		else {
			File.add("Dec _Litemp" + String.valueOf(tempCounter));
			tempStack.push("_Litemp" + String.valueOf(tempCounter));
			Statement += " _Litemp" + String.valueOf(tempCounter++);
		}
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubtractExpression(RSSGrammarParser.SubtractExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSubtractExpression(RSSGrammarParser.SubtractExpressionContext ctx) {
		String Statement = "SUB ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
					break;
		}
		File.add("Dec _Litemp" + String.valueOf(tempCounter));
		tempStack.push("_Litemp" + String.valueOf(tempCounter));
		Statement += " _Litemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionCallExpression(RSSGrammarParser.FunctionCallExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionCallExpression(RSSGrammarParser.FunctionCallExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLtEqExpression(RSSGrammarParser.LtEqExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLtEqExpression(RSSGrammarParser.LtEqExpressionContext ctx) {
		String Statement = "LTEQ ";
		boolean tempused = false;
		int childcount = ctx.getChild(0).getChildCount();	
		switch(childcount) {
		case 1 : if(ctx.getChild(0).getChild(0).getChildCount() == 0)
					Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local");
				 else
					 Statement += "_GReturn";
				 break;
		case 2: Statement += Utilities.getName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global");	
				break;
		case 3: if(ctx.getChild(2).getChildCount() > 2 && ctx.getChild(2).getChildCount() != 4)
					Statement += tempStack.get(tempStack.size() - 2);
				else {
					Statement += tempStack.get(tempStack.size() - 1);
					tempused = true;   }
				break;
		case 4: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(0).toString(), "Local", ctx.getChild(0).getChild(2).toString());
				break;
		case 5: Statement += Utilities.getArrayName(variableMap, ctx.getChild(0).getChild(1).toString(), "Global", ctx.getChild(0).getChild(3).toString());
				break;
		default: Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		
		childcount = ctx.getChild(2).getChildCount();
		
		switch(childcount) {
		case 1: if(ctx.getChild(2).getChild(0).getChildCount() == 0)
					Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local");
				else
					Statement +=  " _GReturn";
				break;
		case 2: Statement +=  " " + Utilities.getName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global");
				break;
		case 3:  if (tempused)
					Statement += " " + tempStack.get(tempStack.size() - 2);
				else
					Statement += " " + tempStack.get(tempStack.size() - 1);
				break;
		case 4: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(0).toString(), "Local", ctx.getChild(2).getChild(2).toString());
				break;
		case 5: Statement += " " +Utilities.getArrayName(variableMap, ctx.getChild(2).getChild(1).toString(), "Global", ctx.getChild(2).getChild(3).toString());
				break;
		default: Statement = Statement += tempStack.get(tempStack.size() - 1);
				 break;
		}
		File.add("Dec _Lbtemp" + String.valueOf(tempCounter));
		tempStack.push("_Lbtemp" + String.valueOf(tempCounter));
		Statement += " _Lbtemp" + String.valueOf(tempCounter++);
		File.add(Statement);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}