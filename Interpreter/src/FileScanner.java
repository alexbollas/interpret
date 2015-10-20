import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FileScanner {
	public static String fileLine="";
	public static int count=0;
	public static Map<String, Integer> varMap = new HashMap<>();
	
	public static void concat(String file)
	{
		
		
		
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(file));
		    String line = "";
		    while((line=reader.readLine()) !=null){
		    	
		    	line = line.trim();
		  //  while ((line = reader.readLine()) != null)
		   // {
		    	
		    	fileLine=fileLine+line+ " ";
		    }
		    reader.close();
		    
		  }
		  catch (Exception e)
		  {
		    System.out.println("Exception occurred trying to read file");
		    System.exit(0);
		    e.printStackTrace();
		    
		  }
		
	
		
	}
	/**
	 * 
	 * @param moveToNext if true moves counter to next token
	 * @return current token
	 */
	public static String getToken(boolean moveToNext){
		int i = count;
		char c;
		String token="";
		if((i+1)<fileLine.length()){
			 c = fileLine.charAt(i);
		}
		else{
			return null;
		}

		
		while(c==' ' && fileLine.length()>(i+1)){
			i++;
			c=fileLine.charAt(i);
		}
		if(c==','||c==';'||c=='*'||c=='+'||c=='('||c==')' ||c=='[' ||c==']'||c=='='||c=='-'
				||c=='|'){
			token=String.valueOf(c);
			i++;
			if(moveToNext){count=i;}
			return token;
		}
		if(c==':'){
			if(fileLine.length() > i+1){
				if(fileLine.charAt(i+1) == '='){
					token=":=";
					i = i+2;
					if(moveToNext){count=i;}
					return token;
				}
				else{
					i=i+1;
					if(moveToNext){count=i;}
					return(":");
				}
			}
			else{
				System.out.println("error: cannot end with :");
				System.exit(0);
				return null;
			}
		}
		if(c=='!'){
			if(fileLine.length()>i+1){
				if(fileLine.charAt(i+1)=='='){
					i=i+2;
					if(moveToNext){count=i;}
					return "!=";
				}
				else{
					i++;
					if(moveToNext){count=i;}
					return "!";
				}
			}
		}
		if(c=='>'){
			if(fileLine.length()>i+1){
				if(fileLine.charAt(i+1)=='='){
					i=i+2;
					if(moveToNext){count=i;}
					return ">=";
				}
				else{
					i++;
					if(moveToNext){count=i;}
					return ">";
				}
			}
		}
		if(c=='<'){
			if(fileLine.length()>i+1){
				if(fileLine.charAt(i+1)=='='){
					i=i+2;
					if(moveToNext){count=i;}
					return "<=";
				}
				else{
					i++;
					if(moveToNext){count=i;}
					return "<";
				}
			}
		}
		if(Character.isDigit(c)){
			token=token+c;
			i++;
			while(fileLine.length()>i && Character.isDigit(fileLine.charAt(i))){
				token=token+fileLine.charAt(i);
				i++;
			}
			if(Character.isLetter(fileLine.charAt(i))){
				System.out.println("error letter after num");
				System.exit(0);
			}
					if(moveToNext){count=i;}
					return token;
			}
		if(Character.isLetter(c)){
			
			token=token+c;
			i++;
			while((fileLine.length()>i+1) && (Character.isLetter(fileLine.charAt(i))
					||Character.isDigit(fileLine.charAt(i)))){
				token=token+fileLine.charAt(i);
				i++;
			}
					if(moveToNext){count=i;}
					return token;
			}
		if(c!=' '){
		System.out.println("\n Error while scaning: invalid character: "+ c);
		System.exit(0);
		}
			
		return null;
	}
	public static String currentToken(){
		return getToken(false);
	}
	public static String nextToken(){
		return getToken(true);
	}

	public static void match(String token){
		if(!token.equals(getToken(true))){
			System.out.println("Error: expected "+ token);
			System.exit(0);
		}
	}
	public static boolean isInt(String token){
		int i = 0;
		while(i<token.length()){
			if(!Character.isDigit(token.charAt(i))){
				return false;
			}
			i++;
		}
		return true;
	}
	/*public static String nextToken(){
		String token = currentToken();
		if(token !=null){
		count = count + token.length()+1;
		return token;
		}
		else{
			return null;
		}
	}
	*/
	public static boolean isKeyWord(String token){
		if(token.equals("program")||token.equals("begin")||token.equals("end")||token.equals("int")
				||token.equals("input")||token.equals("output")||token.equals("if")
				||token.equals("then")||token.equals("endif")||token.equals("else")
				||token.equals("end")||token.equals("do")||token.equals("while")
				||token.equals("enddo")||token.equals("AND")||token.equals("OR")
				||token.equals("case")){
			return true;
		}
		return false;
	}
	public static void declVar(String id){
		varMap.put(id, null);
	}
	public static void setVar(String id, int constant){
		varMap.remove(id);
		varMap.put(id, constant);
	}
	public static boolean isDeclared(String id){
		if(varMap.containsKey(id)){
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args)
	{
		
		
		Scanner sc = new Scanner(System.in);
		String x="";
		String file = args[0];
		concat(file);
		String token="";
		while(token!=null){
			token=nextToken();
			if(token!=null){
			System.out.print(token + " ");
			}
			else{
				System.out.print("EOF");
			}
		}
		System.out.println("\n\n");
		count=0; //reset counter
		Prog prog = new Prog();
		prog.parse();
		System.exit(0);

		System.out.println("Enter n for next token, enter q to quite");
		while(!x.equals("q")){
			x = sc.nextLine();
			if(x.equals("q")){
				break;
			}
			if(x.equals("n")){
				System.out.print("Next Token: ");
				System.out.println("|" +nextToken()+ "|");
			}
			if(x.equals("c")){
				System.out.print("Current Token: ");
				System.out.println("|" +currentToken()+ "|");
			}
		}
	}

}
