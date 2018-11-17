package chap16.Graph.BFS;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS_Graph {

	private int V; // 노드의 개수
	private LinkedList<Integer> list[]; // 인접 리스트

	// 배열 리스트 만듬
	BFS_Graph(int v) {
		V = v;
		list = new LinkedList[v];
		for (int i = 0; i < v; ++i) // 인접 리스트 초기화
			list[i] = new LinkedList();
	}

	// 리스트 형태로 연결
	void addEdge(int v, int w) {
		list[v].add(w);
	}

	// s 까지의 경로 너비우선 탐색
	void BFS(int start) {
		// 노드의 방문 여부 판단 (초깃값: false)
		boolean visited[] = new boolean[V];

		// BFS 구현을 위한 큐(Queue) 생성
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
		visited[start] = true;
		queue.add(start);
		System.out.print(start + " ");

		// 큐(Queue)가 빌 때까지 반복
		while (queue.size() != 0) {
			// 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
			start = queue.poll();

			// 방문한 노드와 인접한 모든 노드를 가져온다.
			Iterator<Integer> i = list[start].listIterator();

			while (i.hasNext()) {
				int n = i.next();
				// 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
				if (!visited[n]) {
					visited[n] = true;
					System.out.print(n + " ");
					queue.add(n);
				}
			}

		}
	}

}
