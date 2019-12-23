package Graph;

public class Prim {
	private double[][] Graph;
	private boolean[] marked;
	private double[] distTo;
	private int[] edgeTo;
	private int N;
	private final  int s = 0;
	private	double sumWeight; 

	public Prim(MatrixGraph matrixGraph) {
		N = matrixGraph.V();
		this.Graph = matrixGraph.matrix();
		marked = new boolean[N];
		distTo = new double[N];
		edgeTo = new int[N];
		sumWeight = 0.0;
		prim();
	}
	
	public void prim() {
		for(int i = 0;i < N;i++) {
			distTo[i] = Graph[s][i];
			edgeTo[i] = i;
		}
		marked[s] = true;
		for(int i = 0;i < N;i++) {
			int k = -1;
			double min = Double.MAX_VALUE; 
			for(int j = 0;j < N;j++) {
				if(!marked[j] && distTo[j] < min) {
					k = j;
					min = distTo[j];
					sumWeight += min;
				}
			}
			if(k == -1) break;
			marked[k] = true;
			for(int h = 0;h < N;h++) {
				if(!marked[h] && Graph[k][h] < distTo[h]) {
					distTo[h] = Graph[k][h];
					edgeTo[h] = k;
				}
			}
		}
	}
	public double minWeight() {
		return sumWeight;
	}
}
