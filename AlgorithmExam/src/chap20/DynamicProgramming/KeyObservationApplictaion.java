package chap20.DynamicProgramming;

public class KeyObservationApplictaion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyObservation keyObservation = new KeyObservation(10);
		System.out.println("재귀 방식 : "+ keyObservation.recursiveMat(9, 9));
		System.out.println("Memoization 방식 :"+ keyObservation.memoizationMat(9, 9));
	}

}

class KeyObservation{
	
	public int[][] m = {{6,7,12,5},
						{5,3,11,18},
						{7,17,3,3},
						{8,10,14,9}
						};
	
	public int[][] L = {{-1,-1,-1,-1},
						{-1,-1,-1,-1},
						{-1,-1,-1,-1},
						{-1,-1,-1,-1}
						};
	KeyObservation(int size){
		init(size);
	}
	void init(int size){
		m= new int [size][size];
		L= new int [size][size];
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				int num = (int) (Math.random()*9)+1;
				m[i][j]=num;
				L[i][j]=-1;
				System.out.print(num+" ");
			}
			System.out.println();
		}
				
		
	}
	
	
	int recursiveMat(int i, int j){
		if(i==0&&j==0)
			return m[i][j];
		else if(i==0)
			return recursiveMat(i, j-1) + m[i][j];
		else if(j==0)
			return recursiveMat(i-1, j) + m[i][j];
		else 
			return Math.min(recursiveMat(i-1, j), recursiveMat(i, j-1)) + m[i][j];
	}
	
	
	
	int memoizationMat(int i, int j){
		if(L[i][j]!=-1)
			return L[i][j];
		if(i==1 && j==1)
			L[i][j] = m[i][j];
		else if(i==0)
			L[i][j] = memoizationMat(i, j-1) + m[i][j];
		else if(j==0)
			L[i][j] = memoizationMat(i-1, j) + m[i][j];
		else 
			L[i][j] = Math.min(recursiveMat(i-1, j), recursiveMat(i, j-1)) + m[i][j];
		
		return L[i][j];
	}
	
}
