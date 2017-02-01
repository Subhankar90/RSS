package Compiler;
import java.util.LinkedHashMap;

public class Utilities {
	
	public static String getName(LinkedHashMap<String, String> map, String str, String Scope) {		
		try {
			int i = Integer.parseInt(str) ;
			return String.valueOf(i);
		}
		
		catch(NumberFormatException nfe) {
			String dataType = "";
			String returnValue = "";
				if(str.contains("\""))
					return str;
				if(str.compareToIgnoreCase("true") == 0 || str.compareToIgnoreCase("false") == 0)
					return str;
			dataType = (String) map.get(str + " " + Scope);
			if(Scope == "Global")		
				switch(dataType) {
					case "String": returnValue = "_Gs" +str;
								 	break;
					case "Integer" : returnValue = "_Gi" +str;
									break;
					case "Boolean" : returnValue = "_Gb" +str;
									break;				
					default: System.out.println("The variable \""+ str + "\" has not been declared properly");
							 System.exit(0);
							 break;
				}
			else
				switch(dataType) {
				case "String": returnValue = "_Ls" +str;
							 	break;
				case "Integer" : returnValue = "_Li" +str;
								break;
				case "Boolean" : returnValue = "_Lb" +str;
								break;				
				default: System.out.println("The variable \""+ str + "\" has not been declared properly");
						 System.exit(0);
						 break;
			}
			return returnValue;	
		}		
	}

	public static String getArrayName(LinkedHashMap<String, String> map, String str, String Scope, String position) {
		try {			
			int i = Integer.parseInt(position) ;
			String dataType = "";
			String returnValue = "";
			dataType = (String) map.get(str + " " + Scope + " Array");
			if(position!="NULL")
			if(Scope == "Global")			
				switch(dataType) {
				case "String": returnValue = "_Gs" +str + "[]." + String.valueOf(i);
							 	break;
				case "Integer" : returnValue = "_Gi" +str + "[]." + String.valueOf(i);
								break;
				case "Boolean" : returnValue = "_Gb" +str + "[]." + String.valueOf(i);	
								break;				
				default: System.out.println("The array \""+ str + "\" has not been declared properly");
						 System.exit(0);
						 break;
				}
			else
				switch(dataType) {
				case "String": returnValue = "_Ls" +str + "[]." + position;
							 	break;
				case "Integer" : returnValue = "_Li" +str + "[]." + position;
								break;
				case "Boolean" :returnValue = "_Lb" +str + "[]." + position;	
								break;				
				default: System.out.println("The array \""+ str + "\" has not been declared properly");
						 System.exit(0);
						 break;
				}
			return returnValue;	
		}
		
		catch(NumberFormatException nfe) {
		String dataType = "";
		String returnValue = "";
		dataType = (String) map.get(str + " " + Scope + " Array");
		if(position != null){
			if(Scope == "Global")
				switch(dataType) {
				case "String": returnValue = "_Gs" +str + "[]." + getName(map,position,"Global");
							 	break;
				case "Integer" : returnValue = "_Gi" +str + "[]." + getName(map,position,"Global");
								break;
				case "Boolean" : returnValue = "_Gb" +str + "[]." + getName(map,position,"Global");	
								break;				
				default: System.out.println("The array \""+ str + "\" has not been declared properly");
						 System.exit(0);
						 break;
				}
			else 
				switch(dataType) {
				case "String": returnValue = "_Ls" +str + "[]." + getName(map,position,"Local");
							 	break;
				case "Integer" : returnValue = "_Li" +str + "[]." + getName(map,position,"Local");
								break;
				case "Boolean" : returnValue = "_Lb" +str + "[]." + getName(map,position,"Local");	
								break;				
				default: System.out.println("The array \""+ str + "\" has not been declared properly");
						 System.exit(0);
						 break;
				}
				
		}
		else if(position== null)
			switch(dataType) {
			case "String": returnValue = "_Ls" +str + "[]";
						 	break;
			case "Integer" : returnValue = "_Li" +str + "[]";
							break;
			case "Boolean" :returnValue = "_Lb" +str + "[]";
							break;				
			default: System.out.println("The array \""+ str + "\" has not been declared properly");
					 System.exit(0);
					 break;
			}
		return returnValue;	
		}
	}
	
	public static boolean StringCheck(LinkedHashMap<String, String> map, String str, String Scope, Boolean Array) {
		String dataType = "";
		if(str.contains("\""))
			return true;
		if(Array)
			dataType = (String) map.get(str + " " + Scope + " Array");
		else
			dataType = (String) map.get(str + " " + Scope);
		if(dataType != null)
			if(dataType.compareToIgnoreCase("String") == 0)
				return true;
		return false;
	}
	
	public static boolean StringCheckTemp(String str) {
		if(str.contains("_LsTemp"))
			return true;
		return false;
	}
}

