package abs;

public class LinkQueue {
	private Node first;
	private Node last;
	private int N;
	private class Node {
		int item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void enqueue(int item) {
		Node olast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else olast.next = last;
		N++;
	}
	public int dequeue() {
		int item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
    public static void main(String[] args) {
		LinkQueue queue = new LinkQueue();
		queue.enqueue(1);
		System.out.println("Dequeue: " + queue.dequeue());
		queue.dequeue();
	}
}
