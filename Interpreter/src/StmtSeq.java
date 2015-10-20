
public class StmtSeq {
	private Stmt stmt;
	private StmtSeq stmt_seq;
	private int altNo;
	public StmtSeq(){
		stmt=null;
		stmt_seq=null;
		altNo=0;
	}
	
	void parse(){
		stmt = new Stmt(); stmt.parse();
		String currentToken = FileScanner.currentToken();
		if(currentToken.equals("end") || currentToken.equals("while")
				|| currentToken.equals("endif")
				|| currentToken.equals("else") || currentToken==null){
			return;
		}
		else{
			
			altNo=1;
			stmt_seq=new StmtSeq(); stmt_seq.parse();
		}
		
	}
	void print(){
		
	}
	void exec(){
		this.stmt.exec();
		if(this.altNo==1){
			this.stmt_seq.exec();
		}
	}
}
