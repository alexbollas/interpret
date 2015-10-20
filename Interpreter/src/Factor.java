
public class Factor {
	private int constant; Factor factor; Expr expr; int altNo;
	public Factor(){
		constant=0;
		factor=null;
		expr=null;
		altNo=0;
	}
	void parse(){
		String token = FileScanner.currentToken();
		
		//check if token is number, if it is altNo=1 and return
		if(FileScanner.isInt(token)){
			altNo=1;
			FileScanner.nextToken();
			constant=Integer.parseInt(token);
			
			return;
		}
		//check if token is variable, if it is altNo=2 return
		if(FileScanner.isDeclared(token)){
			altNo=2;
			FileScanner.nextToken();
			return;
		}
		if(token.equals("-")){
			altNo=3;
			FileScanner.nextToken();
			factor=new Factor(); factor.parse();
			return;
		}
		if(token.equals("(")){
			altNo=4;
			FileScanner.nextToken();
			expr = new Expr(); expr.parse();
			FileScanner.match(")");
			return;
		}
		System.out.println("unexpected token: " + token);
		System.exit(0);
	}
	void print(){
		
	}
	void exec(){
		
	}
	
}
