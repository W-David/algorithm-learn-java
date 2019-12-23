package Graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(Digraph G) {
		int V = G.V();
		marked = new boolean[V];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		
		for(int v = 0;v < V;v++) {
			if(!marked[v]) dfs(G,v);
		}
	}
	
	public void dfs(Digraph G,int v) {
		pre.enqueue(v);
		marked[v] = true;
		for(int w : G.edgeList(v)) {
			if(!marked[w]) dfs(G,w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}
