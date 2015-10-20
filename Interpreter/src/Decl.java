
public class Decl {
	private IdList idlist;
	public Decl(){
		idlist=null;
	}
	void parse(){
		FileScanner.match("int");
		idlist = new IdList(); idlist.parse();
		FileScanner.match(";");
	}
	void print(){
		
	}
	void exec(){
		this.idlist.exec();
	}
}
