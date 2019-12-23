package abs;

public class LinkStack {
	private Node first;
	private int N;
	private class Node {
		int item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void push(int item) {
		Node ofirst = first;
		first = new Node();
		first.item = item;
		first.next = ofirst;
		N++;
	}
	public int pop() {
		int item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public static void main(String[] args) {
		LinkStack stack = new LinkStack();
		stack.push(1);
		stack.push(2);
		System.out.println("Pop: " + stack.pop() );
	}
}
