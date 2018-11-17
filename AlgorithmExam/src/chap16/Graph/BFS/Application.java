package chap16.Graph.BFS;

public class Application {

	public static void main(String[] args) {
		BFS_Graph g = new BFS_Graph(8);

		g.addEdge(1, 2); // a->b
		g.addEdge(2, 1); // b->a
		
		g.addEdge(1, 3); // a->c
		g.addEdge(3, 1); // c->a
		
		g.addEdge(2, 4); // b->d
		g.addEdge(4, 2); // d->b
		
		g.addEdge(2, 5); // b->e
		g.addEdge(5, 2); // e->b
		
		g.addEdge(3, 5); // c->f
		g.addEdge(5, 3); // f->c
		
		g.addEdge(3, 6); // c->g
		g.addEdge(6, 3); // g->c
		
		g.addEdge(5, 7); // c->h
		g.addEdge(7, 5); // h->c

		g.BFS(1); /* 주어진 노드를 시작 노드로 BFS 탐색 */
		//
	}

}
