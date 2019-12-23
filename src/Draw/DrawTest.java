package Draw;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class DrawTest {
	public static void drawRectangle() {
		int N = 100;
		double[] a = new double[N];
		for(int i = 0;i < N;i++) {
			a[i] = StdRandom.random();
			System.out.println(a[i]);
		}
		for(int i = 0;i < N;i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	public static void main(String[] args) {
		drawRectangle();
	}
}
