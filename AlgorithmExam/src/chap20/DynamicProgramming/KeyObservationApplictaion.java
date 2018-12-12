package chap20.DynamicProgramming;

public class KeyObservationApplictaion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyObservation keyObservation = new KeyObservation();
		System.out.println(keyObservation.recursiveMat(1, 2));
	}

}

class KeyObservation{
	
	public int[][] m = {{6,7,12,5},
						{5,3,11,18},
						{7,17,3,3},
						{8,10,14,9}
						};
	
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
	
}
