package chap03.N_Queens;

public class NQueen {
	
	int N;

	int [] cols ;
	
	public NQueen(int N) {
		// TODO Auto-generated constructor stub
		this.N= N;
		cols = new int[N+1];
	}
	
	boolean queens(int level) {
		
		if(!promising(level))
			return false;
		else if(level==N) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(cols[i]==j) {
						System.out.print("X");
					}else {
						System.out.print("0");
					}
				}
				System.out.println();
			}
			
			
			return true;
		}
		for(int i = 1; i<=N;i++) {
			cols[level+1]=i;
			if(queens(level+1))
				return true;
		}
			
		return false;	
		
		
	}
	
	boolean promising(int level) {
	    for(int i=0;i<level;i++){
	        	
	        
	        if(cols[i]==cols[level] || Math.abs(level-i)== Math.abs(cols[level]-cols[i])){
	        
	            return false;
	          
	        }
	        
	    }
	    return true;


	
		
	}
	
}
