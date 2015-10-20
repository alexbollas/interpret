
public class Out {
	private IdList id_list;
	public Out(){
		id_list=null;
	}
	void parse(){
		FileScanner.match("output");
		id_list = new IdList(); id_list.parse();
		FileScanner.match(";");
	}
	void print(){
		
	}
	void exec(){
		
	}
}
