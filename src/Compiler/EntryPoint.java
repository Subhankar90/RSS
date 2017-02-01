/*
 * Entry point for RSS Language Compiler
 */
package Compiler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EntryPoint {

	public static void main(String[] args) throws IOException {
		RSSGrammarLexer lexer = new RSSGrammarLexer(new ANTLRFileStream(args[0]));
		RSSGrammarParser parser = new RSSGrammarParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        ParseTreeWalker walker = new ParseTreeWalker(); 
        walker.walk(new RSSGrammarBaseListener(), tree);        
       
        createFile();
	}
	
	public static void createFile() throws IOException  {
		FileOutputStream fos = new FileOutputStream(new File("intermediatecode.rssc"));	 
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos)); 
		for( String str : RSSGrammarBaseListener.File) {
			writer.write(str);
			writer.newLine();
		}	 
		writer.close();
	}
}
