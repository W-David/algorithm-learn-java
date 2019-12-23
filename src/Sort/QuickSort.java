package Sort;

public class QuickSort extends SortTemplate {
	private int partition(int[] a,int lo,int hi) {
		int i = lo,j = hi + 1;
		int v =  a[i];
		while(true) {
			while(a[++i] < v) if(i == hi) break;
			while(v < a[--j]) if(j == lo) break;
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	private void sort(int[] a,int lo,int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	public void sort(int[] a) {
		sort(a,0,a.length-1);
	}
}
