package Graph;

import java.util.ArrayList;

import edu.princeton.cs.algs4.In;

public class Graph {
	private final int V;
	private int E;
	private ArrayList<Integer>[] edgeList;
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		edgeList = (ArrayList<Integer>[]) new ArrayList[V];
		for(int v = 0;v < V;v++) {
			edgeList[v] = new ArrayList<Integer>();
		}
	}
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i < E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public Iterable<Integer> edgeList(int v){
		return edgeList[v];
	}
	public void addEdge(int v,int w) {
		edgeList[v].add(w);
		edgeList[w].add(v);
		E++;
	}
}
