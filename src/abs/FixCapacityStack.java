package abs;

public class FixCapacityStack {
	private int[] a;
	private int N;
	public FixCapacityStack(int cap) {
		a = new int[cap];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	} 
	public void push(int item) {
		a[N++] = item;
	}
	public int pop() {
		return a[--N];
	}
	public static void main(String[] args) {
		FixCapacityStack stack = new FixCapacityStack(10);
		System.out.println("Push 1,2,3");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("Pop " + stack.pop());
		System.out.println("Size: " + stack.size());
	}
}
