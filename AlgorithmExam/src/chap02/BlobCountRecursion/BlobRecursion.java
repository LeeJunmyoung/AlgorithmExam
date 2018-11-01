package chap02.BlobCountRecursion;

public class BlobRecursion {
	private static int N=8;
	private static int [][] blob = {
   { 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 },
   { 1 , 0 , 1 , 0 , 0 , 0 , 1 , 0 },
   { 1 , 0 , 1 , 0 , 1 , 0 , 0 , 0 },
   { 1 , 0 , 0 , 0 , 0 , 1 , 1 , 0 },
   { 1 , 0 , 1 , 1 , 1 , 0 , 1 , 0 },
   { 1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 },
   { 1 , 1 , 1 , 1 , 1 , 1 , 0 , 1 },
   { 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }
   };
	
	private static final int NOTING_COLOR  = 0 ; //아무것도 아닌 블록
	private static final int CONTAIN_COLOR = 1 ; //카운팅 해야 하는 블록
	private static final int CHECKED_COLOR = 2 ; //체크한 블록
	
	public static int COUNT=0;
	public static int countBlock(int x, int y){
		if(x<0||y<0||x>N-1||y>N-1){
			return 0;
		}else if(blob[x][y]!=CONTAIN_COLOR){
			return 0;
		}else{
			blob[x][y]=CHECKED_COLOR;
			
			return 1 + countBlock(x+1,y)    + countBlock(x+1, y-1)
			+  countBlock(x, y-1)   + countBlock(x-1, y-1)
			+  countBlock(x-1, y)   + countBlock(x-1, y+1)
			+  countBlock(x, y+1)   + countBlock(x+1, y+1) ;//우측부터 시계반대방향
			
			
			
			
		}
		
	}
    public static void printMaze() {
        for (int i = 0; i < blob.length; i++) {
            for (int j = 0; j < blob[0].length; j++) {
                System.out.print(blob[i][j] + " ");
            }
            System.out.println();
        }
    }
		
	
}
