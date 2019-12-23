package Graph;

import edu.princeton.cs.algs4.In;

public class MatrixGraph {
	private int V;
	private int E;
	private double[][] graph;
	
	public MatrixGraph(int V) {
		this.V = V;
		this.E = 0;
		graph = new double[V][V];
	}
	
	public MatrixGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0;i < V;i++) {
			for(int j = 0;j < V;j++) {
				graph[i][j] = Double.MAX_VALUE;
			}
		}
		for(int i = 0;i < E;i++) {
			int v = in.readInt();
			int w = in.readInt();
		    double weight = in.readDouble();	
		    addEdge(v,w,weight);
		}
	}
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public double[][] matrix(){
		return graph;
	}
	public void addEdge(int v,int w,double weight) {
		graph[v][w] = graph[w][v] = weight;
		E++;
	}
}
