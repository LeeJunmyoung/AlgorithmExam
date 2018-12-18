package chap20.DynamicProgramming;

public class MCMApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {10,20,50,2,8,10,5};
		int arr[] = {10,100,5,50};
		// 10X20 , 20X50 , 50X2 , 2X8 , 8X10 , 10X5 6개 행렬
		MatrixChainMultiple mcm = new MatrixChainMultiple(arr);
		mcm.matrixChain();
	}

}

class MatrixChainMultiple{
	
	int p[];
	int m[][];
	int n;
	
	MatrixChainMultiple(int []arr){
		p = arr;
		n = arr.length-1;
		m = new int [n+1][n+1];
		for(int i=1;i<=n;i++)
			m[i][i] = 0;
	}
	
	public void matrixChain(){
		for(int r=1;r<=n-1;r++){
			for(int i=1;i<=n-r;i++){
				int j=i+r;
				m[i][j]= m[i+1][j]+p[i-1]*p[i]*p[j];
				for(int k=i+1;k<=j-1;k++){
					if(m[i][j]>m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j]){
						m[i][j]=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					}
				}
			}
		}
		System.out.println("최소값 : "+m[1][n]);
	}
}