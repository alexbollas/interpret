
public class Cmpr {
	Expr expr; CmprOp cmp;
	public Cmpr(){
		expr=null;
		cmp=null;
	}
	void parse(){
		FileScanner.match("[");
		
		expr = new Expr(); expr.parse();
		cmp = new CmprOp(); cmp.parse();
		expr = new Expr(); expr.parse();
		FileScanner.match("]");

	}
	void print(){
		
	}
	void exec(){
		
	}
}
