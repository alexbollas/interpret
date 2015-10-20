
public class Caseletlist {
	private Caselet caselet; Caseletlist caseletlist;
	public Caseletlist(){
		caselet=null;
		caseletlist=null;
	}
	void parse(){
		caselet = new Caselet(); caselet.parse();
		if(FileScanner.currentToken().equals("|")){
			FileScanner.nextToken();
			caseletlist = new Caseletlist(); caseletlist.parse();
		}
	}

}
