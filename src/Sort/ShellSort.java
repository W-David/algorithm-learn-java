package Sort;

public class ShellSort extends SortTemplate {
	public void sort(int[] a) {
		int N = a.length;
		int gap = 1;
		while(gap < N / 3) gap = gap * 3 + 1;
		while(gap >= 1) {
			for(int i = gap; i < N;i += gap) {
				int temp = a[i];
				int j = i;
				while(j > 0 && temp < a[j-gap]) {
					a[j] = a[j-gap];
					j -= gap;
				}
				a[j] = temp;
				show(a);
				clear();
			}
			gap = gap / 3;
		}
		
	}
}
