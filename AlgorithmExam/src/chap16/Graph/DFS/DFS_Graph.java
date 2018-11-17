package chap16.Graph.DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS_Graph {

	private int nodeSize; // 노드의 개수
	private LinkedList<Integer> list[]; // 인접 리스트
	
	
	
	//배열 리스트 만듬
	DFS_Graph(int size) {
		nodeSize = size;
		list = new LinkedList[size];
		for (int i = 0; i < size; ++i) // 인접 리스트 초기화
			list[i] = new LinkedList();
	}

	// 리스트 형태로 연결 
	void addEdge(int v, int w) {
		list[v].add(w);
	}



	  void DFSUtil(int v, boolean visited[]) {
	      // 현재 노드를 방문한 것으로 표시하고 값을 출력
	      visited[v] = true;
	      System.out.print(v + " ");

	      // 방문한 노드와 인접한 모든 노드를 가져온다.
	      Iterator<Integer> i = list[v].listIterator();
	      while (i.hasNext()) {
	          int n = i.next();
	          // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
	          if (!visited[n])
	              DFSUtil(n, visited); // 순환 호출
	      }
	  }

	  
	  void DFS(int v) {
	      // 노드의 방문 여부 판단 (초깃값: false)
	      boolean visited[] = new boolean[nodeSize];

	      // v를 시작 노드로 DFSUtil 순환 호출
	      DFSUtil(v, visited);
	  }

	

}
