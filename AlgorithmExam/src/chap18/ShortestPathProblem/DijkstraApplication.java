package chap18.ShortestPathProblem;

public class DijkstraApplication {

	public static void main(String[] args) {
		Dijkstra g = new Dijkstra(6);
        g.input(1, 2, 7);
        g.input(1, 3, 9);
        g.input(1, 6, 14);
        g.input(2, 3, 10);
        g.input(2, 4, 15);
        g.input(3, 4, 11);
        g.input(3, 6, 2);
        g.input(6, 5, 9);
        g.input(4, 5, 6);
        
        g.dijkstra(1);


	}
	
}

class Dijkstra {
	private int vertexNum; // 노드들의 수
	private int weight[][]; // 노드들간의 가중치 저장할 변수

	public Dijkstra(int _vertexNum){
        this.vertexNum = _vertexNum;
        weight = new int[_vertexNum+1][_vertexNum+1];
         
    }

	public void input(int i, int j, int w) {
		weight[i][j] = w;
		weight[j][i] = w;
	}

	public void dijkstra(int v) {
		int distance[] = new int[vertexNum + 1]; // 최단 거리를 저장할 변수
		boolean[] check = new boolean[vertexNum + 1]; // 해당 노드를 방문했는지 체크할 변수

		// distance값 초기화.
		for (int i = 1; i < vertexNum + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		// 시작노드값 초기화.
		distance[v] = 0;
		check[v] = true;

		//출발지 에서의 가중치 갱신
		for (int i = 1; i < vertexNum + 1; i++) {
			if (!check[i] && weight[v][i] != 0) {
				distance[i] = weight[v][i];
			}
		}

		for (int a = 0; a < vertexNum - 1; a++) {
			int min = Integer.MAX_VALUE;
			int min_index = -1;

			//확정되는 않은 노드, 최단거리를 확인
			for (int i = 1; i < vertexNum + 1; i++) {
				if (!check[i] && distance[i] != Integer.MAX_VALUE) {
					if (distance[i] < min) {
						min = distance[i];
						min_index = i;
					}
				}
			}
			
			//해당지점에서 다른 노드들간의 가중치를 비교해서 업데이트
			check[min_index] = true;
			for (int i = 1; i < vertexNum + 1; i++) {
				if (!check[i] && weight[min_index][i] != 0) {
					if (distance[i] > distance[min_index] + weight[min_index][i]) {
						distance[i] = distance[min_index] + weight[min_index][i];
					}
				}
			}

		}

		// 결과값 출력
		for (int i = 1; i < vertexNum + 1; i++) {
			System.out.print(i+" 까지의 최단경로 : ");
			System.out.print(distance[i] + " \n");
		}
		System.out.println("");

	}

}
