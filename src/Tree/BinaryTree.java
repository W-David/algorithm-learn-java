package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	private class Node{
		int data;
		Node left,right;
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	public BinaryTree() {
		root = null;
	}
	public boolean isEmpty(BinaryTree tree) {
		return tree.root == null;
	}
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	private void preOrder(Node node) {
		if(node == null) return;
		System.out.printf("%2d",node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	private void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.printf("%2d",node.data);
		inOrder(node.right);
	}
	public void postOrder() {
		postOrder(root);
		System.out.println();
	}
	private void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.printf("%2d",node.data);
	}
	public void levelOrder() {
		levelOrder(root);
	}
	private void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();				
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node h = queue.poll();
			System.out.printf("%2d",h.data);
			if(h.left != null) queue.offer(h.left);
			if(h.right != null) queue.offer(h.right);
		}
	}
	public boolean get(int key) {
		// k is not -1
		return get(root,key) == key;
	}
	private int get(Node node,int key) {
		if(node == null) return -1;
		if(node.data < key) return get(node.left,key);
		else if(node.data > key) return get(node.right,key);
		else return key;
	}
	public void put(int key) {
		root = put(root,key);
	}
	private Node put(Node node,int key) {
		if(node == null) return new Node(key);
		if(node.data > key) node.left = put(node.left,key);
		else if(node.data < key) node.right = put(node.right,key);
		else node.data = key;
		return node;
	}
	public int min() {
		return min(root).data;
	}
	private Node min(Node node) {
		if(node.left == null) return node;
		return min(node.left);
	}
	public int max() {
		return max(root).data;
	}
	private Node max(Node node) {
		if(node.right == null) return node;
		return max(node.right);
	}
	public void delete(int key) {
		root = delete(root,key);
	}
	private Node delete(Node node,int key) {
		if(node == null) return node;
		if(key < node.data) node.left = delete(node.left,key);
		else if(key > node.data) node.right = delete(node.right,key);
		else if(node.left != null && node.right != null){
			node.data = min(node.right).data;
			node.right = delete(node.right,node.data);
		} else {
			node = node.left == null ? node.right : node.left;
		}
		return node;
	}
	public static BinaryTree createBinaryTree(int[] a) {
		int N = a.length;
		BinaryTree binaryTree = new BinaryTree();
		for(int i = 0;i < N;i++) {
			binaryTree.put(a[i]);
		}
		return binaryTree;
	}
	public static void main(String[] args) {
		int[] a = {4,2,6,1,3,5,7};
		BinaryTree binaryTree = createBinaryTree(a);
		binaryTree.levelOrder();
		binaryTree.delete(2); 
		System.out.println();
		binaryTree.levelOrder();
	}
}
