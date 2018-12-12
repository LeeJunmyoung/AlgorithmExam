package chap20.DynamicProgramming;

public class KeyObservationApplictaion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size =10;
		KeyObservation keyObservation = new KeyObservation(size);
		
		
		System.out.println("재귀 방식 : "+ keyObservation.recursiveMat(size-1, size-1));
		
		keyObservation.initL();
		
		System.out.println("Memoization 방식 :"+ keyObservation.memoizationMat(size-1, size-1));
		
		keyObservation.initL();
		
		System.out.println("Bottom-up 방식 :"+ keyObservation.bottomUpMat(size-1, size-1));
		System.out.println();
		keyObservation.printPath();
		keyObservation.printPathRecursive(size-1, size-1);
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
	
	String[][] P;
	
	KeyObservation(int size){
		init(size);
	}
	
	void initL(){
		for(int i=0;i<L.length;i++)
			for(int j=0;j<L.length;j++)
				L[i][j]=-1;
	}
	void init(int size){
		m= new int [size][size];
		L= new int [size][size];
		P= new String [size][size];
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
	
	int bottomUpMat(int x, int y){
		
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m.length;j++){
				if(i==0 && j==0){
					L[i][j] = m[i][j];
					P[i][j] = "-";
				}else{
					if(i==0){
						L[i][j] = L[i][j-1] + m[i][j];
						P[i][j] = "<";
					}else if(j==0){
						L[i][j] = L[i-1][j] + m[i][j];
						P[i][j] = "^";
					}else if(L[i-1][j]<L[i][j-1]){
						L[i][j] = L[i-1][j]+m[i][j];
						P[i][j] = "^";
					}else{
						L[i][j] = L[i][j-1]+m[i][j];
						P[i][j] = "<";
					}
					
				}
			}
		}
		
		
		return L[x][y];
	}
	
	void printPath(){
		for(int i=0;i<P.length;i++){
			for(int j=0;j<P.length;j++){
				System.out.print(P[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	void printPathRecursive(int i, int j){
		if(P[i][j]=="-")
			System.out.println(i + " " + j);
		else{
			if(P[i][j]=="<"){
				printPathRecursive(i, j-1);
			}else{
				printPathRecursive(i-1, j);
			}
			System.out.println(i + " " + j);
		}
	}
	
}
