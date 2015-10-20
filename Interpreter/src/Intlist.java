
public class Intlist {
	private int constant; Intlist intlist;
	public Intlist(){
		constant=0;
		intlist=null;
	}
	void parse(){
		String token = FileScanner.nextToken();
		if(!FileScanner.isInt(token)){
			System.out.println("Error, expected an integer instead of: " + token);
		}
		constant=Integer.parseInt(token);
		if(FileScanner.currentToken().equals(",")){
			FileScanner.nextToken();
			intlist = new Intlist(); intlist.parse();
		}
	}
}
