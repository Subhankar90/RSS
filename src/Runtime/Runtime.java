package Runtime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runtime {
	
	public static int LineNumber = 0;
	public static ArrayList<String> records = new ArrayList<String>();
	public static Stack<CustomMap> symbolTable = new Stack<CustomMap>();
	public static Stack<String> pointerStack = new Stack<String>();
	public static String[] registers = new String[10];

	public static void main(String[] args) {	          
        readFile("intermediatecode.rssc");
        try {
            for(LineNumber= 0 ; LineNumber< records.size();LineNumber++) {
         	   List<String> tokens = getTokens(records.get(LineNumber));
         	   if(records.get(LineNumber).compareToIgnoreCase("Programend") == 0) { 
         		   Parser.ProcessTokens(tokens); 
         		   break;   
         	   }    	   
         	   Parser.ProcessTokens(tokens);  	    
             }
        }
        catch(Exception e) {
        	System.out.println("Error Processing the File");
        }
	}

	private static void readFile(String filename) {
			try	{ 
	            BufferedReader reader = new BufferedReader(new FileReader(filename));
	            String line;
	            while ((line = reader.readLine()) != null)
	              records.add(line);     	            
	            reader.close();
	          }
	          catch (Exception e) {
	            System.err.format("Exception occurred trying to read '%s'.", filename);
	            e.printStackTrace();
	          }
	}
	
	public static List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<String>();
		String regex = "\"([^\"]*)\"|(\\S+)";
		Matcher m = Pattern.compile(regex).matcher(str);
		while (m.find()) {
	        if (m.group(1) != null)
	            tokens.add( m.group(1));
	        else
	            tokens.add( m.group(2));
		}
		return tokens;		
	}
}
