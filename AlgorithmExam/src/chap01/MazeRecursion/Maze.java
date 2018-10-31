package chap01.MazeRecursion;

public class Maze {

	private static int N=8;
	private static int [][] maze = {
   { 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 },
   { 1 , 0 , 1 , 0 , 0 , 0 , 1 , 0 },
   { 1 , 0 , 1 , 0 , 1 , 0 , 0 , 0 },
   { 1 , 0 , 0 , 0 , 0 , 1 , 1 , 0 },
   { 1 , 0 , 1 , 1 , 1 , 0 , 1 , 0 },
   { 1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 },
   { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
   { 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }
   };
	
	private static final int PATHWAY_COLOR = 0 ; //지나갈수 있는 숫자
	private static final int WALL_COLOR    = 1 ; //벽
	private static final int BLOCK_COLOR   = 2 ; //출구까지의 경로가 없는 셀
	private static final int PATH_COLOR    = 3 ; //방문한 경로이지만 아직 출구를 못찾은 경로
			
	public static boolean findMazePath(int x,int y){
		if(x<0||y<0||x>=N||y>=N)
			return false;
		else if (maze[x][y]!=PATHWAY_COLOR)
			return false;
		else if (x==N-1 && y==N-1){
			maze[x][y] = PATH_COLOR;
			return true;
		}else{
			maze[x][y] = PATH_COLOR;
			if(findMazePath(x-1, y) 
			|| findMazePath(x+1, y) 
			|| findMazePath(x, y-1) 
			|| findMazePath(x, y+1)
			){
				return true;
			}
			maze[x][y] = BLOCK_COLOR; 
			return false;
		}
	}
	
    public static void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
    
   
	
	
	
}
