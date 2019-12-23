package Graph;

import java.io.File;

import edu.princeton.cs.algs4.In;

public class DFS {
	private boolean[] marked;
	private int count;
	public DFS(Graph G) {
		marked = new boolean[G.V()];
		count = 0;
	}
	public void dfs(Graph G,int v) {
		marked[v] = true;
		count++;
		for(Integer w : G.edgeList(v)) {
			if(!marked[w]) dfs(G,w);
		}
	}
	public int count() {
		return count;
	}
	public static void main(String[] args) {
		File Gfile = new File("D:\\algs4-data\\mediumG.txt ");
		Graph G = new Graph(new In(Gfile));
		DFS dfs = new DFS(G);
		dfs.dfs(G, 0);
		System.out.println("Union Count: " + dfs.count());
	}
}
