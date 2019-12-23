package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	private int[] pre;
	private int[] size;
	private double minWeight;
	private ArrayList<Edge> edges;

	class Edge{
		int v,w;
		double weight;
		public Edge(int v,int w,double weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}
	}

	public Kruskal(int N,int E) {
		pre = new int[N];
		size = new int[N];
		minWeight = 0.0;
		edges = new ArrayList<>(E);

		for(int i = 0;i < N;i++) {
			pre[i] = i;
			size[i] = 1;
		}
	}
	public void createGraph(int E,Scanner scan) {
		for(int i = 0;i < E;i++) {
			int v = scan.nextInt();
			int w = scan.nextInt();
			double weight = scan.nextDouble();
			Edge edge = new Edge(v,w,weight);
			edges.add(edge);
		}
	}
	
	public int find(int v) {
		while(v != pre[v]) v = pre[v];
		return v;
	}

	public boolean connected(int v,int w) {
		int vroot = find(v),wroot = find(w);
		if(vroot == wroot) return false;
		if(size[vroot] < size[wroot]) {
			pre[vroot] = wroot;
			size[wroot] += size[vroot];
		} else {
			pre[wroot] = vroot;
			size[vroot] += size[wroot];
		}
		return true;
		
	}
	public void MST(int E) {
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge a, Edge b) {
				return a.weight - b.weight > 0 ? 1 : -1;
			}
		});
		for(int i = 0;i < E;i++) {
			Edge cur = edges.get(i);
			System.out.printf("%3d%3d  %.2f\n",cur.v,cur.w,cur.weight);
			if(connected(cur.v, cur.w)) {
				 minWeight += cur.weight;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(),E = scan.nextInt();
		Kruskal kruskal = new Kruskal(N, E);
		kruskal.createGraph(E, scan);
		scan.close();
		kruskal.MST(E);
		System.out.println(kruskal.minWeight);
	}
}
