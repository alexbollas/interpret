
public class Expr {
	private Term term; Expr expr; int altNo;
	public Expr(){
		term=null;
		expr=null;
		altNo=0;
	}
	void parse(){
		term = new Term(); term.parse();
		//check if there is more to the Expr (should either be + or - if there is more)
		if(FileScanner.currentToken().equals("+")){
			altNo=1;
			FileScanner.nextToken();
			expr = new Expr(); expr.parse();
			return;
		}
		if(FileScanner.currentToken().equals("-")){
			altNo=2;
			FileScanner.nextToken();
			expr= new Expr(); expr.parse();
			return;
		}
		
		altNo=3;
		
	}
	void print(){
		
	}
	void exec(){
		//difference between plus and minus?
	}
}
