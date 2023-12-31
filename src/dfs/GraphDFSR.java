package dfs;

import java.util.ArrayList;
import java.util.List;

import graph.AdjSet;
import graph.Graph;

//递归遍历图
public class GraphDFSR {
	private Graph g;
	private List<Integer> res;
	private boolean visited[];
	
	public GraphDFSR(Graph g) {
		this.g = g;
		if (g == null) return;
		this.res = new ArrayList<>();
		this.visited = new boolean[g.getV()];
		
		for (int v = 0; v < g.getV(); v++) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}
		
	private void dfs(int v) {
		res.add(v);
		visited[v] = true;
		for (int w : g.getAdjVertex(v)) {
			if (!visited[w])
				dfs(w);
		}
	}
	
	public List<Integer> getRes(){
		return res;
	}
	
	public static void main(String[] args) {
		String graphDoc = "/Users/xiuli/eclipse-workspace/leetcode2/src/graph/graph_dfs.txt";
		Graph g = new AdjSet(graphDoc);
		GraphDFSR graphDfsR = new GraphDFSR(g);
		System.out.println(graphDfsR.getRes());
	}
}
