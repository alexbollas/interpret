
public class Stmt {
	private Assign assign; If ifStmt; Loop loop; In in; Out out; Case caseStmt; int intNo;
	public Stmt(){
		assign=null;
		ifStmt=null;
		loop=null;
		in= null;
		out= null;
		caseStmt=null;
		intNo = 0;
		
	}
	void parse(){
		String token = FileScanner.currentToken();
		if(token.equals("if")){
			intNo=1;
			ifStmt = new If(); ifStmt.parse();
			return;
		}
		if(token.equals("do")){
			intNo=2;
			loop = new Loop(); loop.parse();
			return;	
		}
		if(token.equals("input")){
			intNo=3;
			in = new In(); in.parse();
			return;
		}
		if(token.equals("output")){
			intNo=4;
			out = new Out(); out.parse();
			return;
		}
		if(token.equals("case")){
			intNo=5;
			caseStmt = new Case(); caseStmt.parse();
			return;
		}
		//should be variable 
		if(!FileScanner.isKeyWord(token)){//check to make sure current token is not a keyword
			if(Character.isLetter(token.charAt(0))){//check to make sure variable name starts with letter
			intNo=6;
			
			assign = new Assign(); assign.parse();
			
			return;
			}
			else{
				//some form of error checking
				System.out.println("Error in Stmt, unexpected token: " + token);
				System.exit(0);
			}
		}
		else{
			System.out.println("Error: inapropriate use of keyword: "+ token);
			System.exit(0);
		}
	}
	void print(){
		
	}
	void exec(){
		//check this.altNo and then call exec on the appropriate object
	}
}
