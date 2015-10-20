
public class Loop {
	private int altNo; Cond cond; StmtSeq stmtseq;
	public Loop(){
		altNo=0;
		cond=null;
		stmtseq=null;
	}
	void parse(){
		FileScanner.match("do");
		//System.out.println("here in loop, token: " + FileScanner.currentToken(false));
		stmtseq = new StmtSeq(); stmtseq.parse();
		FileScanner.match("while");
		cond = new Cond(); cond.parse();
		FileScanner.match("enddo");
		FileScanner.match(";");
	}		
	
	void exec(){
		
	}
}
