
public class DeclSeq {
	private DeclSeq decl_seq;
	private Decl decl;
	private int alt;
	public DeclSeq(){
		decl_seq=null;
		decl=null;
		alt=0;
	}
	void parse(){
		decl = new Decl(); decl.parse();
		if(FileScanner.currentToken().equals("begin")){
			return;
		}
		else{
			alt=1;
			decl_seq = new DeclSeq(); decl_seq.parse();
		}
		
	}
	void print(){
		
	}
	void exec(){
		this.decl.exec();
		if(this.alt==1){
			this.decl_seq.exec();
		}
	}
}
