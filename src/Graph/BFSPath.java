package Graph;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BFSPath {
	private boolean[] marked;
	private int[] prev;
	private final int s;
	private Queue<Integer> queue;

	public BFSPath(Graph G,int s) {
		marked = new boolean[G.V()];
		prev = new int[G.V()];
		queue = new Queue<Integer>();
		this.s = s;
		bfs(G,s);
	}
	
	public void bfs(Graph G,int s) {
		queue.enqueue(s);
		marked[s] = true;
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(Integer w : G.edgeList(v)) {
				if(!marked[w]) {
					queue.enqueue(w);
					prev[w] = v;
					marked[w] = true;
				}
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
		BFSPath bfsPath = new BFSPath(G, s);
		for(int v = 0;v < G.V();v++) {
			System.out.print(s + " to " + v + ": ");
			for(int x : bfsPath.pathTo(v)) {
				if(x == s) System.out.print(x);
				else System.out.print("->" + x);
			}
			System.out.println();
		}
	}
	
}
