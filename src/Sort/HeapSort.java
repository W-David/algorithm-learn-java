package Sort;

public class HeapSort extends SortTemplate{
	public void sort(int[] a) {
		int N = a.length;
		for(int k = N/2 - 1;k >= 0;k--) {
			sink(a,k,N);
		}
		for(int i = 1;i < N;i++) {
			exch(a,0,N-i);
			sink(a,0,N-i);
		}
	}
	private void sink(int[] a,int k,int N) {
		while(2*k + 1 < N) {
			int j = 2*k + 1;
			if(j < N-1 && less(a,j,j+1)) j++;
			if(!less(a,k,j)) break;
			exch(a,k,j);
			k = j;
		}
	}
}
