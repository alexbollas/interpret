
public class Assign {
	private Expr expr; String id; 
	public Assign(){
		id="";
		expr=null;
	}
	void parse(){
		//some how check if filescanner.next() is equal to a declared variable name
		id = FileScanner.nextToken();
		if(!FileScanner.isDeclared(id)){
			System.out.print("Error: " + id + " never declared");
			System.exit(0);
		}
	
		FileScanner.match(":=");
		expr = new Expr(); expr.parse();

		FileScanner.match(";");
		
		
	}
	void print(){
		
	}
	void exec(){
		
	}
}
