
public class Caselet {
	private Intlist intlist; Expr expr;
	public Caselet(){
		intlist=null;
		expr=null;
	}
	void parse(){
		intlist=new Intlist(); intlist.parse();
		FileScanner.match(":");
		expr = new Expr(); expr.parse();
	}
}
