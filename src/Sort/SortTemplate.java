package Sort;

import edu.princeton.cs.algs4.StdDraw;

public class SortTemplate {
	public boolean less(int[] a,int i,int j) {
		return a[i] < a[j];
	}
	public void exch(int[] a,int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		show(a);
		clear();
	}
	public void clear() {
		StdDraw.clear();
	}
	public void show(int[] a) {
		int N = a.length;
		for(int i = 0;i < N;i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 200.0;
			double rw = 0.5 / N;
			double rh = a[i] / 200.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
}
