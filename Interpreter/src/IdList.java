import java.util.Map;
import java.util.HashMap;

public class IdList {
	private IdList idlist;
	private int altNo;
	public IdList(){
		idlist=null;
		altNo=0;
	}
	void parse(){
		String token = FileScanner.nextToken();
		//error check if token is an string of characters and is not a key word
		if(!Character.isLetter(token.charAt(0))){
			System.out.println("Error in declaring: "+token+", variable must start with letter");
			System.exit(0);
		}
		if(FileScanner.isKeyWord(token)){
			System.out.print("Error, cannot use keyword: " + token + " as varaible");
			System.exit(0);
		}
		
		FileScanner.declVar(token);	
		
	
		if(FileScanner.currentToken().equals(",")){
			altNo=1;
			FileScanner.nextToken();
			idlist = new IdList(); idlist.parse();
		}
	}
	void print(){
		
	}
	void exec(){
		if(this.altNo==1){
			this.idlist.exec();
		}
	}
}
