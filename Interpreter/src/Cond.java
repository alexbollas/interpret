
public class Cond {
	private Cmpr cmpr; Cond cond; int altNo;
	public Cond(){
		cmpr=null;
		cond=null;
		altNo=0;
	}
	void parse(){
		if(FileScanner.currentToken().equals("!")){
			altNo=1;
			FileScanner.nextToken();
			cond = new Cond(); cond.parse();
			return;
		}
		if(FileScanner.currentToken().equals("(")){
			FileScanner.nextToken();
			cond = new Cond(); cond.parse();
			
			//check if AND or OR statement
			if(FileScanner.currentToken().equals("AND")){
				altNo=2;
				FileScanner.nextToken();
				cond = new Cond(); cond.parse();
				FileScanner.match(")");
				return;
			}
			else if(FileScanner.currentToken().equals("OR")){
				altNo=3;
				FileScanner.nextToken();
				cond = new Cond(); cond.parse();
				FileScanner.match(")");
				return;
			}
			else{
				System.out.println("Error, expecting AND or OR insead of token: "+ FileScanner.currentToken());
				System.exit(0);
				//some form of errror control
			}
		}
		else if(FileScanner.currentToken().equals("[")){
			
			altNo=4;
			cmpr = new Cmpr(); cmpr.parse();
			return;
		}
		else{
			System.out.println("Error in Cond, unexpected token: " + FileScanner.currentToken());
			System.exit(0);
		}
	}
	void print(){
		
	}
	void exec(){
		
	}
}
