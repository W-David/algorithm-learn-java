package abs;

public class ResizingArrayStack {
	private int[] a  = new int[1];
	private int N = 0;
	public boolean isEmpty() {
		return N == 0;
	}
	private void resize(int size) {
		int[] temp = new int[size];
		for(int i = 0;i < N;i++) {
			temp[i] = a[i];
		}
		a = temp;
		System.out.println("resize: " + a.length);
	}
	public void push(int item) {
		if(N == a.length) resize(2 * a.length);
		a[N++] = item;
	}
	public int pop() {
		int item = a[--N];
		if(N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}
	public static void main(String[] args) {
		ResizingArrayStack stack = new ResizingArrayStack();
		for(int i = 0;i < 10;i++) {
			stack.push(i);
		}
		for(int i = 0;i < 10;i++) {
			stack.pop();
		}
	}
}
