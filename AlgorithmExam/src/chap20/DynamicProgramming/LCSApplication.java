package chap20.DynamicProgramming;

public class LCSApplication {

	
	
	public static void main(String args[]){
		String x = "ABCDA";
		String y = "ACBDEA";
		
		LCS lcs = new LCS(x, y);
		
		System.out.println(lcs.lcs(x.length(),y.length()));
	}
}


class LCS{
	
	char [] x;
	char [] y;
	int [][] c;
	
	public LCS(String _x, String _y) {
		x= _x.toCharArray();
		y= _y.toCharArray();
		c=new int[_x.length()+1][_y.length()+1];
		for(int i=0;i<_x.length();i++)
			c[i][0]=0;
		for(int j=0;j<_y.length();j++)
			c[0][j]=0;
		
	}
	
	int lcs(int _x,int _y){
		
		for(int i=1; i<=_x; i++)
			for(int j=1; j<=_y; j++)
				if(x[i-1]==y[j-1])
					c[i][j] = c[i-1][j-1] + 1;
				else
					c[i][j] = Math.max(lcs(i-1,j), lcs(i,j-1));
		return c[_x][_y];
	}
	
}