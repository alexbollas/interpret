
public class In {
	private IdList id_list;
	public In(){
		id_list=null;
	}
	void parse(){
		FileScanner.match("input");
		id_list = new IdList(); id_list.parse();
		FileScanner.match(";");
	}
	void print(){
		
	}
	void exec(){
		
	}
}
