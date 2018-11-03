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
	        //level 위치에 현재 시험할 퀸이 놓여져 있는 상태이고
	        //우리는 그 퀸과 i= 0 ~ level-1 에 놓여있는 퀸이 문제를 일으키는지만 보면 된다.
	        
	        	
	        
	        if(cols[i]==cols[level] || Math.abs(level-i)== Math.abs(cols[level]-cols[i])){
	            //i번째 퀸의 위치와 level위치의 퀸이 같은 일직선상에 있는경우
	            //또는
	            //i번째 퀸의 위치와 level위치의 퀸이 대각선상에 있는 경우.
	            //밑변과 높이가 같으면 대각선상에 있다고 볼수 있다.
	            return false;
	            //이 경우는 불가능 하므로 false를 리턴
	        }
	        
	    }
	    return true;


	
		
	}
	
}
