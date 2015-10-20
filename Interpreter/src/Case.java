
public class Case {
	private Caseletlist caseletlist; Expr expr;   
	public Case(){
		caseletlist=null;
		expr=null;
	}
	void parse(){
		FileScanner.match("case");
		String var = FileScanner.nextToken();
		//check if var is a variable
		FileScanner.match("of");
		caseletlist = new Caseletlist(); caseletlist.parse();
		FileScanner.match("else");
		expr = new Expr(); expr.parse();
		FileScanner.match("end");
		FileScanner.match(";");
	}
}
