
public class Term {
	private Factor factor; Term term; int altNo;
	public Term(){
		factor=null;
		term = null;
		altNo=0;
	}
	void parse(){
		factor = new Factor(); factor.parse();
		if(FileScanner.currentToken().equals("*")){
			altNo=1;
			FileScanner.nextToken();
			term= new Term(); term.parse();
			return;
		}
		else{
			altNo=2;
		}
	}
	void print(){
		
	}
	void exec(){
		this.factor.exec();
		if(this.altNo==1){
			this.term.exec();
		}
	}
}
