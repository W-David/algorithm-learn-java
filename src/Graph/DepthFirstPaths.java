package Graph;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] prev;
	private final int s;
	
	public DepthFirstPaths(Graph G,int s) {
		marked = new boolean[G.V()];
		prev = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v) {
		marked[v] = true;
		for(Integer w : G.edgeList(v)) {
			if(!marked[w]) {
				prev[w] = v;
				dfs(G,w);
			}
		}
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!marked[v]) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x != s;x = prev[x]) path.push(x); 
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) {
		File Gfile = new File("D:\\algs4-data\\mediumG.txt ");
		Graph G = new Graph(new In(Gfile));
		int s = 0;
		DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
		for(int v = 0;v < G.V();v++) {
			System.out.println(s + " to " + v + ": ");
			for(int x : depthFirstPaths.pathTo(v)) {
				if(x == s) System.out.print(x);
				else System.out.print("->" + x);
			}
			System.out.println();
		}
	}
}
