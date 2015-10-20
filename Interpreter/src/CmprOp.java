
public class CmprOp {
	private int altNo;
	public CmprOp(){
		altNo=0;
	}
	void parse(){
		String token = FileScanner.nextToken();
		switch(token){
		case "<": altNo=1; break;
		case "=": altNo=2; break;
		case "!=": altNo=3; break;
		case ">": altNo=4; break;
		case ">=": altNo=5; break;
		case "<=": altNo=6; break;
		default : System.out.println("Error, invalid compare operator: " + token); System.exit(0);
					break;
		}
		
	}
	void print(){
			
	}
	void exec(){
		if(this.altNo==1){
			
		}
	}
}
