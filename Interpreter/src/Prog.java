
public class Prog {
	private DeclSeq decl_seq;
	private StmtSeq stmt_seq;
	
	public Prog(){
		decl_seq=null;
		stmt_seq=null;
	}
	void parse(){
		FileScanner.match("program");
		decl_seq = new DeclSeq(); decl_seq.parse();
		FileScanner.match("begin");
		stmt_seq = new StmtSeq(); stmt_seq.parse();
		FileScanner.match("end");
		System.out.println("succesful end");
		System.exit(0);
		FileScanner.match("eof");
			
				//error handling
		}
	void print(){
		
	}
	void exec(){
	decl_seq.exec();
	stmt_seq.exec();
	}
	

}
