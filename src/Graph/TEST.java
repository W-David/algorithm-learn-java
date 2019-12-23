package Graph;

import java.io.File;

import edu.princeton.cs.algs4.In;

public class TEST {
	public static void main(String[] args) {
		File graphFile = new File("D:\\algs4-data\\tinyEWD.txt");
		MatrixGraph matrixGraph = new MatrixGraph(new In(graphFile));
		Prim prim = new Prim(matrixGraph);
		System.out.println("MST weight: " + prim.minWeight());
	}
}
