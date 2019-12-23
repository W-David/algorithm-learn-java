package Graph;

import java.io.File;

import edu.princeton.cs.algs4.In;

public class Topological {
	private Iterable<Integer> order;
	
	public Topological(Digraph G) {
		DirectedCycle directedCycle = new DirectedCycle(G);
		if(!directedCycle.hasCycle()) {
			DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
			order = depthFirstOrder.reversePost();
		}
	}

	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean isDAG() {
		return order != null;
	}
	public static void main(String[] args) {
		File DiGfile = new File("D:\\algs4-data\\tinyG.txt ");
		Digraph digraph = new Digraph(new In(DiGfile));
		Topological topological = new Topological(digraph);
		for(int v : topological.order()) {
			System.out.printf("%3d",v);
		}
	}
}
