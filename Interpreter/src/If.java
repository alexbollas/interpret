
public class If {
	private Cond cond; StmtSeq stmtseq; StmtSeq stmtseq2; int altNo;
	public If(){
		cond=null;
		stmtseq=null;
		altNo = 0;
	}
	void parse(){
		FileScanner.match("if");
		cond = new Cond(); cond.parse();
		FileScanner.match("then");
		stmtseq = new StmtSeq(); stmtseq.parse();
		if(FileScanner.currentToken().equals("else")){
			altNo=1;
			FileScanner.nextToken();
			stmtseq2 = new StmtSeq(); stmtseq2.parse();
		}
	
		FileScanner.match("endif");
		FileScanner.match(";");
	}
	void print(){
		
	}
	void exec(){
		this.cond.exec();
		this.stmtseq.exec();
		if(altNo==1){
			this.stmtseq2.exec();
		}
	}
}
