package chap17.MinimumSpannigTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

public class KruskalMSTApplication {

	public static void main(String[] args) {
		System.out.println("test");
	}

}

class KruskalMST {

	int edgeNum;
	int vertexNum;

	Edge[] edges;

	public KruskalMST(int _edgeNum, int _vertexNum) {
		this.edgeNum = _edgeNum;
		this.vertexNum = _vertexNum;
	}

	public void setEdges(Edge[] _edges) {
		this.edges = _edges;
	}

	void run() {
		List<Edge> result = new ArrayList<Edge>(); // 저장 배열
		Arrays.sort(edges); // 정렬
		
		
		
		
		int i =0;
		while(result.size()>vertexNum){
			
			Edge next_edge = edges[i++];
			
		}
	}
	
	String find(EdgeSet[] edgeSets,String root){
		
		return null;
	}
	
}

class EdgeSet {
	private String parent;
	private int rank;
	public String getParent() {
		return parent;
	}
	public EdgeSet setParent(String parent) {
		this.parent = parent;
		return this;
	}
	public int getRank() {
		return rank;
	}
	public EdgeSet setRank(int rank) {
		this.rank = rank;
		return this;
	}
}

class Edge implements Comparable<Edge> {

	private String src;// 지점 A
	private String dest;// 지점 B
	private int weight; // 가중치

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}// 내림차순

}