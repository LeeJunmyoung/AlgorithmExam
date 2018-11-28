package chap17.MinimumSpannigTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

public class KruskalMSTApplication {

	public static void main(String[] args) {
		KruskalMST kruskalMst = new KruskalMST(11, 7);
		
		Edge edge = new Edge();
		edge.setSrc("A");
		edge.setDest("B");
		edge.setWeight(7);
		
		Edge edge1 = new Edge();
		edge1.setSrc("A");
		edge1.setDest("D");
		edge1.setWeight(5);
		
		Edge edge2 = new Edge();
		edge2.setSrc("B");
		edge2.setDest("C");
		edge2.setWeight(8);
		
		Edge edge2_1 = new Edge();
		edge2_1.setSrc("B");
		edge2_1.setDest("E");
		edge2_1.setWeight(7);
		
		Edge edge3 = new Edge();
		edge3.setSrc("C");
		edge3.setDest("E");
		edge3.setWeight(5);
		
		Edge edge4 = new Edge();
		edge4.setSrc("B");
		edge4.setDest("D");
		edge4.setWeight(9);
		
		Edge edge5 = new Edge();
		edge5.setSrc("D");
		edge5.setDest("E");
		edge5.setWeight(15);
		
		Edge edge6 = new Edge();
		edge6.setSrc("D");
		edge6.setDest("F");
		edge6.setWeight(6);
		
		Edge edge7 = new Edge();
		edge7.setSrc("E");
		edge7.setDest("F");
		edge7.setWeight(8);
		
		Edge edge8 = new Edge();
		edge8.setSrc("E");
		edge8.setDest("G");
		edge8.setWeight(9);
		
		Edge edge9 = new Edge();
		edge9.setSrc("F");
		edge9.setDest("G");
		edge9.setWeight(11);
		
		Edge[] edges = {edge,edge1,edge2,edge3,edge4,edge5,edge6,edge7,edge8,edge9,edge2_1};
		kruskalMst.setEdges(edges);
		kruskalMst.run();
		
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
		edges = new Edge[_edges.length];
		this.edges = _edges;
	}

	void run() {
		Edge[] result = new Edge[vertexNum-1]; // 저장 배열
		Arrays.sort(edges); // 정렬

		HashMap<String, EdgeSet> edgeSetMap = new HashMap<String, EdgeSet>();
		initMap(edgeSetMap,edges);
		int i = 0;
		int e = 0;
		while (e  < vertexNum-1) {

			Edge next_edge = edges[i++];
			String x = find(edgeSetMap,next_edge.getSrc());
			String y = find(edgeSetMap,next_edge.getDest());
			
			if(!x.equals(y)){
				result[e++]= next_edge;
				union(edgeSetMap, x, y);
				
			}
		}
		
		System.out.println("==============MST Kruskal Algorithm=============");
		
		Arrays.asList(result)
		      .forEach( value->{
		    	  System.out.println(value.getSrc() + " -- " + value.getDest() + " == " + value.getWeight());
		      }); 
	}

	String find(HashMap<String, EdgeSet> edgeSetMap, String root) {

		if (edgeSetMap.get(root).parent!=null 
				&&!edgeSetMap.get(root).parent.equals(root)
			) {
			edgeSetMap.get(root).parent=find(edgeSetMap,edgeSetMap.get(root).parent);
		}else{
			return root;
		}

		return edgeSetMap.get(root).parent;
	}
	
	void union(HashMap<String,EdgeSet>edgeSetMap,String x, String y){
		String xroot = find(edgeSetMap,x);
		String yroot = find(edgeSetMap,y);
		
		
		if(edgeSetMap.get(xroot).rank < edgeSetMap.get(yroot).rank){
			edgeSetMap.get(xroot).parent=yroot;
		}else if(edgeSetMap.get(xroot).rank > edgeSetMap.get(yroot).rank){
			edgeSetMap.get(yroot).parent=xroot;
		}else{
			edgeSetMap.get(yroot).parent=xroot;
			edgeSetMap.get(xroot).rank++;
		}
		
	}
	
	void initMap(HashMap<String, EdgeSet> edgeSetMap,Edge[] edges){
		for(int num=0;num<edges.length;num++){
			EdgeSet edgeSet = new EdgeSet();
			edgeSet.parent=edges[num].getSrc();
			edgeSet.rank=edges[num].getWeight();
			edgeSetMap.put(edgeSet.parent, edgeSet);
			
			EdgeSet edgeSet1 = new EdgeSet();
			edgeSet1.parent=edges[num].getDest();
			edgeSet1.rank=edges[num].getWeight();
			edgeSetMap.put(edgeSet1.parent, edgeSet1);
		}
	}
}

class EdgeSet {
	String parent;
	int rank = 0;
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
//		if(this.getWeight()>o.getWeight()){
//			return -1;
//		}else if(this.getWeight()<o.getWeight()){
//			return 1;
//		}else{
//			return 0;
//		}
		return this.getWeight()-o.getWeight();
	}// 내림차순

}