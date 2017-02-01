package Runtime;
import java.util.List;

public class Parser {

	public static void ProcessTokens(List<String> tokens) {
		
		switch (tokens.get(0)) {
		case "Programstart":Execution.Insert("Programstart","NULL");
			break;
		case "Class" : 		Execution.Insert("Class",tokens.get(1));
			break;
		case "Func" : 		Execution.Insert(tokens.get(0), tokens.get(1));
			break;
		case "Dec" : 		Execution.declareValues(tokens);
			break;
		case "Print" : 		Execution.printStatement(tokens);
			break;
		case "SET" : 		Execution.updateSymbolTable(tokens);
			break;
		case "Functionend": Execution.popSymbolTable("Func");
			break;
		case "Classend" : 	Execution.popSymbolTable("Class");
			break;
		case "Programend" : Execution.popSymbolTable("Programstart");
			break;
		case "ADD" : 		Execution.Math(tokens);
			break;
		case "SUB" : 		Execution.Math(tokens);
			break;
		case "MUL" : 		Execution.Math(tokens);
			break;
		case "DIV" : 		Execution.Math(tokens);
			break;
		case "MOD" : 		Execution.Math(tokens);
			break;
		case "GT" : 		Execution.Math(tokens);
			break;
		case "GTEQ" : 		Execution.Math(tokens);
			break;
		case "LT" : 		Execution.Math(tokens);
			break;
		case "LTEQ" : 		Execution.Math(tokens);
			break;
		case "NQ" : 		Execution.Math(tokens);
			break;
		case "EQ" : 		Execution.Math(tokens);
			break;
		case "AND" : 		Execution.LogicalOperation(tokens);
			break;
		case "OR" : 		Execution.LogicalOperation(tokens);
			break;
		case "Push" :		Execution.PushOperation(tokens);
			break;
		case "POP" : 		Execution.PopOperation(tokens);
			break;
		case "If" : 		Execution.IfHandling(tokens);
			break;
		case "Else" : 		Execution.ElseHandling(tokens);
			break;
		case "Endif" : 		Execution.EndIfHandling();
					   		Execution.popSymbolTable("If");
			break;
		case "Endelse" : 	Execution.popSymbolTable("Else");
			break;
		case "Forloop" : 	Execution.Insert("For", "NULL");;
			break;
		case "Endloop" : 	Execution.popSymbolTable("For");
			break;
		case "Goto" : 		Execution.GotoHandling(tokens);
			break;
		default : break;
		}
	}

}
