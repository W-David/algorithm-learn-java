package Sort;

import edu.princeton.cs.algs4.StdRandom;

public class Test {
	public static void Print(int[] a) {
		for(int i = 0;i < a.length;i++) {
			System.out.printf("% 3d",a[i]);
			if((i % 10) == 9) System.out.println();
		}
	}
	public static void main(String[] args) {
		SortTemplate template = new SortTemplate();
		int N = 30;
		int[] a = new int[N];
		for(int i = 0;i < N;i++) {
			a[i] = (int) (StdRandom.random() * 100);
		}
		System.out.println("Unsort array: ");
		Print(a);
	    template.show(a);
//		BubbleSort bubbleSort = new BubbleSort();
//		bubbleSort.sort(a);
//		InsertSort insertSort = new InsertSort();
//		insertSort.sort(a);
//		SelectSort selectSort = new SelectSort();	
//		selectSort.sort(a);
//	    ShellSort shellSort = new ShellSort();
//	    shellSort.sort(a);
//	    MergeSort mergeSort = new MergeSort();
//	    mergeSort.sort(a);
//	    QuickSort quickSort = new QuickSort();
//	    quickSort.sort(a);
	    HeapSort heapSort = new HeapSort();
	    heapSort.sort(a);
		System.out.println("Sorted array: ");
		Print(a);
		template.show(a);
	}
}
