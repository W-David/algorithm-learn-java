package Graph;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private int[] prev;
	private Stack<Integer> cycle;
	private boolean[] onStack; 
	
	public DirectedCycle(Digraph G) {
		int V = G.V();
		marked = new boolean[V];
		prev = new int[V];
		onStack = new boolean[V];
		
		for(int v = 0;v < V;v++) {
			if(!marked[v]) dfs(G,v);
		}
	}
	
	public void dfs(Digraph G,int v) {
		onStack[v] = true;
		marked[v] = true;
		for(int w : G.edgeList(v)) {
			if(cycle != null) return;
			else if(!marked[w]) dfs(G,w);
			else if(onStack[w]) {
				cycle = new Stack<Integer>();
				for(int x = v;x != w;x = prev[x]) cycle.push(x);;
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
	
	public static void main(String[] args) {
		File DiGfile = new File("D:\\algs4-data\\tinyG.txt ");
		Digraph digraph = new Digraph(new In(DiGfile));
		DirectedCycle directedCycle = new DirectedCycle(digraph);
		if(directedCycle.hasCycle()) {
			System.out.println("Cycle: ");
			for(int v : directedCycle.cycle()) {
				System.out.printf("%3d",v);
			}
		} else {
			System.out.println("No Cycle!");
		}
	}
}
