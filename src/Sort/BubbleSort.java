package Sort;

public class BubbleSort extends SortTemplate {
	public void sort(int[] a) {
		int N = a.length;
		for(int i = 0;i < N-1;i++) {
			boolean flag = false;
			for(int j = N-1;j > i;j--) {
				if(less(a,j,j-1)) {
					exch(a,j,j-1);
					flag = true;
				}
			}
			if(!flag) break;
		}
	}
}
