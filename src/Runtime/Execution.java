package Runtime;

import java.util.List;

public class Execution {

	public static void Insert(String key, String value) {
		CustomMap map = new CustomMap(key,value);
		Runtime.symbolTable.push(map);
		
	}

	public static void declareValues(List<String> tokens) {
		String key = tokens.get(1);
		String value = "";
		if(tokens.size() == 2)
			switch(tokens.get(1).charAt(2)) {
			case 'i' :	value = "0";
						break;
			case 's' :	value = "NULL";
						break;
			case 'b' : 	value = "false";
						break;
			}
		else {
			String val = "";
			switch(tokens.get(1).charAt(2)) {
			case 'i' :	val = "0";
						break;
			case 's' :	val = "NULL";
						break;
			case 'b' : 	val = "false";
						break;
			}
			for(int i=1; i<Integer.parseInt(tokens.get(2)); i++)
				value += val + ",";
				value += val;
		}
		if(tokens.get(1).compareToIgnoreCase("_GReturn") == 0)
			value = "NULL";
		Insert(key,value);		
	}

	public static void printStatement(List<String> tokens) {
		if(tokens.get(1).charAt(0) == '"' && tokens.get(tokens.size()-1).charAt(tokens.get(tokens.size()-1).length() -1) == '"') {
			String str = "";
			for(int i=1; i<tokens.size();i++)
				str = str + " " +tokens.get(i);
			System.out.println(str.substring(2, str.length()-1));	
		}
		else if(getValue(tokens.get(1)).contains("@Reg"))
			System.out.println(getRegister(Integer.parseInt(tokens.get(1).substring(4, tokens.get(1).length()))));
		else
			  System.out.println(getValue(tokens.get(1)));		
	}

	private static String getValue(String key) {
		String variable = "";
		String position = "";
		int arrayposition = 0;
		
		if(key.compareToIgnoreCase("CurrentLine")== 0)
			return String.valueOf(Runtime.LineNumber);
		if(key.contains("@Reg"))
			return getRegister(Integer.parseInt(key.substring(4)));
		if(key.contains(".")) {
			variable = key.substring(0, key.indexOf("."));
			position = key.substring(key.indexOf(".")+1, key.length());
			arrayposition = Integer.parseInt(getValue(position));
		}
		else
			variable = key;		
		for(int i=Runtime.symbolTable.size() -1 ; i >=0; i--)
			if(variable.equalsIgnoreCase(Runtime.symbolTable.get(i).getKey()))
				if(position == "")
					return Runtime.symbolTable.get(i).getValue();
				else
					return getArrayValue(Runtime.symbolTable.get(i).getValue(),arrayposition);
		
		return key;
	}
	
	private static String getArrayValue(String str, int position) {
		int initialposition = 0;
		int finalposition = str.length();
		int i = 0;
			for(int j= 0 ; j<str.length();j++)
				if(str.toCharArray()[j] == ',') {
					i++;	
					if(i == position)
						initialposition = j +1;
					if(i == position + 1)
						finalposition = j;					
				}
			return str.substring(initialposition, finalposition);
	}
	
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}

	public static void updateSymbolTable(List<String> tokens) {
		String NewValue = getValue(tokens.get(2));
		if(getValue(tokens.get(2)).charAt(0) == '"') {
			String str = "";
			for(int i=2; i<tokens.size();i++)
				str = str + " " + tokens.get(i);
			NewValue = str.substring(2, str.length()-1);
		}
		else if(tokens.get(2).compareToIgnoreCase("CurrentLine") == 0)
			NewValue = String.valueOf(Runtime.LineNumber);
		else if(tokens.get(2).compareToIgnoreCase("PreviousLine") == 0)
			NewValue = String.valueOf(Runtime.LineNumber - 1);
		else if(tokens.get(2).contains("@Reg"))
			NewValue = getRegister(Integer.parseInt(tokens.get(2).substring(4, tokens.get(2).length())));
				
		String Variable = "";
		String position = "";
		int arrayposition = 0;
		if(tokens.get(1).contains(".")) {
			Variable = tokens.get(1).substring(0, tokens.get(1).indexOf("."));
			position = getValue(tokens.get(1).substring(tokens.get(1).indexOf(".")+1, tokens.get(1).length()));
			arrayposition = Integer.parseInt(position);
			NewValue = NewArrayString(getValue(tokens.get(1).substring(0, tokens.get(1).indexOf("."))), NewValue,arrayposition);
		}
		else
			Variable = tokens.get(1);
		if(tokens.get(1).contains("@Reg"))
			setRegister(NewValue,Integer.parseInt(tokens.get(1).substring(4, tokens.get(1).length())));
		
		for(int i = Runtime.symbolTable.size()-1; i>=0; i--) {
			if(Runtime.symbolTable.get(i).getKey().compareToIgnoreCase(Variable) == 0) {
				Runtime.symbolTable.get(i).setValue(NewValue);
				break;
			}
		}
	}
	
	public static String NewArrayString(String OriginalValue, String str, int position) {
		int initialLocation = 0;
		int finalLocation = OriginalValue.length();
		int i = 0;
		for(int j= 0 ; j<OriginalValue.length();j++)
			if(OriginalValue.toCharArray()[j] == ',') {
				i++;	
				if(i == position)
					initialLocation = j +1;
				if(i == position + 1)
					finalLocation = j;					
			}
		return OriginalValue.substring(0, initialLocation) + str + OriginalValue.substring(finalLocation, OriginalValue.length());
	}

	public static String getRegister(int position) {
		return Runtime.registers[position];
	}
	
	public static void setRegister(String NewValue, int Position) {
		Runtime.registers[Position] = NewValue;
	}
	
	public static void popSymbolTable(String str) {
		for(int i = Runtime.symbolTable.size()-1; i>=0; i--)
			if(Runtime.symbolTable.get(i).getKey().compareToIgnoreCase(str) == 0) {
				Runtime.symbolTable.pop();
				return;
			}
			else
				Runtime.symbolTable.pop();
	}

	public static void Math(List<String> tokens) {
		try {
			int operand1 = Integer.parseInt(getValue(tokens.get(1)));
			int operand2 = Integer.parseInt(getValue(tokens.get(2)));
			switch(tokens.get(0)) {
			case "ADD" : updateResult(tokens.get(tokens.size() -1),Integer.toString(operand1+operand2));
				break;
			case "SUB" : updateResult(tokens.get(tokens.size() -1),Integer.toString(operand1-operand2));
				break;
			case "MUL" : updateResult(tokens.get(tokens.size() -1),Integer.toString(operand1*operand2));
				break;
			case "DIV" : updateResult(tokens.get(tokens.size() -1),Integer.toString(operand1/operand2));
				break;
			case "MOD" : updateResult(tokens.get(tokens.size() -1),Integer.toString(operand1%operand2));
				break;
			case "GT" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(operand1>operand2));
				break;
			case "GTEQ" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(operand1>=operand2));
				break;
			case "LT" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(operand1<operand2));
				break;
			case "LTEQ" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(operand1<=operand2));
				break;
			case "EQ" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(operand1==operand2));
				break;
			case "NQ" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(operand1!=operand2));
				break;
			}
		}
		catch(NumberFormatException e) {
			switch(tokens.get(0)) {
			case "ADD" : updateResult(tokens.get(tokens.size() -1),getValue(tokens.get(1))+getValue(tokens.get(2)));
				break;
			}
		}
		
	}
	
	public static void LogicalOperation(List<String> tokens) {
		switch(tokens.get(0)) {
		case "AND" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(Boolean.valueOf(getValue(tokens.get(1))) && Boolean.valueOf(getValue(tokens.get(2)))));
			break;
		case "OR" : updateResult(tokens.get(tokens.size() -1),Boolean.toString(Boolean.valueOf(getValue(tokens.get(1))) || Boolean.valueOf(getValue(tokens.get(2)))));
			break;
		}
	}
	
	public static void updateResult(String variable, String newValue) {
		String var = "";
		String position = "";
		String NewValue = newValue;
		int arrayposition = 0;
		if(variable.contains(".")) {
			var = variable.substring(0, variable.indexOf("."));
			position = getValue(variable.substring(variable.indexOf(".")+1, variable.length()));
			arrayposition = Integer.parseInt(position);
			NewValue = NewArrayString(getValue(variable.substring(0, variable.indexOf("."))), newValue,arrayposition);
		}
		else
			var = variable;
		for(int i = Runtime.symbolTable.size() - 1; i >= 0; i--) {
			if(Runtime.symbolTable.get(i).getKey().compareToIgnoreCase(var) == 0) {
				Runtime.symbolTable.get(i).setValue(NewValue);
				break;
			}
		}
		if(var.contains("@Reg"))
			setRegister(NewValue,Integer.parseInt(var.substring(4, var.length())));
			
	}

	public static void PushOperation(List<String> tokens) {
		String NewValue = getValue(tokens.get(2));
		if(tokens.get(1).compareToIgnoreCase("@Pointerstack") == 0)
			Runtime.pointerStack.push(NewValue);
		
	}

	public static void PopOperation(List<String> tokens) {
		String PoppedValue = "";
		if(tokens.get(1).compareToIgnoreCase("@Pointerstack") == 0) {
			PoppedValue = Runtime.pointerStack.get(Runtime.pointerStack.size() - 1);
			Runtime.pointerStack.pop();
			updateResult(tokens.get(2), PoppedValue);
			
		}
	}

	public static void IfHandling(List<String> tokens) {
		if(getValue(tokens.get(1)).compareToIgnoreCase("true") == 0)
			Execution.Insert("If","NULL");
		else
			for(int i = Runtime.LineNumber + 1; i< Runtime.records.size(); i++) {
				List<String> temptokens = Runtime.getTokens(Runtime.records.get(i));
				if(temptokens.get(0).equalsIgnoreCase("Endif")) {
					Runtime.LineNumber = i;
					return;
				}
			}		
	}

	public static void ElseHandling(List<String> tokens) {
		if(tokens.size() == 1)
			Execution.Insert("Else","NULL");
		else {
			if(getValue(tokens.get(2)).compareToIgnoreCase("true") == 0)
				Execution.Insert("If","NULL");
			else
				for(int i = Runtime.LineNumber + 1; i< Runtime.records.size(); i++) {
					List<String> temptokens = Runtime.getTokens(Runtime.records.get(i));
					if(temptokens.get(0).equalsIgnoreCase("Endif")) {
						Runtime.LineNumber = i;
						return;
					}
				}
		}
			
	}

	public static void EndIfHandling() {
		for(int i = Runtime.LineNumber + 1; i< Runtime.records.size(); i++) {
			List<String> temptokens = Runtime.getTokens(Runtime.records.get(i));
			if(temptokens.get(0).equalsIgnoreCase("Endelse")) {
				Runtime.LineNumber = i;
				return;
			}
		}		
	}

	public static void GotoHandling(List<String> tokens) {
		int line = 0;
		String Line;
		if(tokens.size() == 2) {
			line = Integer.parseInt(getValue(tokens.get(1)));
			Runtime.LineNumber = line -1 ;
			return;
		}
		else {
			Line = tokens.get(1) + " " + tokens.get(2);
			for(int i=0; i< Runtime.records.size(); i++) {
				if(Runtime.records.get(i).compareToIgnoreCase(Line) == 0) {
					Runtime.LineNumber = i - 1;
					return;
				}
			}
		}
		
	}	
}
