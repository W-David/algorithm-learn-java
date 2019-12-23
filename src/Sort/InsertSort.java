package Sort;

public class InsertSort extends SortTemplate {
	public void sort(int[] a) {
		int N = a.length;
		for(int i = 1;i < N;i++) {
			int temp = a[i];
			int j = i;
			while(j > 0 && temp < a[j-1]) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
			show(a);
			clear();
		}
	}
}
