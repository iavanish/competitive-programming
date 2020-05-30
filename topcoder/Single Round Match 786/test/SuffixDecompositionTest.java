import org.junit.Test;
import static org.junit.Assert.*;

public class SuffixDecompositionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] P = new int[] {3, 9, 5};
		int A0 = 0;
		int X = 0;
		int Y = 0;
		int B0 = 0;
		int X1 = 0;
		int Y1 = 0;
		int N = 3;
		assertEquals(4L, new SuffixDecomposition().findTotalFun(P, A0, X, Y, B0, X1, Y1, N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] P = new int[] {10};
		int A0 = 1;
		int X = 2;
		int Y = 2;
		int B0 = 3;
		int X1 = 1;
		int Y1 = 2;
		int N = 4;
		assertEquals(8L, new SuffixDecomposition().findTotalFun(P, A0, X, Y, B0, X1, Y1, N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] P = new int[] {};
		int A0 = 1000001;
		int X = 1000001;
		int Y = 1000001;
		int B0 = 5000001;
		int X1 = 5000001;
		int Y1 = 5000001;
		int N = 4;
		assertEquals(6L, new SuffixDecomposition().findTotalFun(P, A0, X, Y, B0, X1, Y1, N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] P = new int[] {};
		int A0 = 1812447358;
		int X = 1812447358;
		int Y = 1812447358;
		int B0 = 42524;
		int X1 = 2565262;
		int Y1 = 2676642;
		int N = 6;
		assertEquals(7L, new SuffixDecomposition().findTotalFun(P, A0, X, Y, B0, X1, Y1, N));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] P = new int[] {};
		int A0 = 1010;
		int X = 2010;
		int Y = 3010;
		int B0 = 900010;
		int X1 = 9000;
		int Y1 = 76540;
		int N = 8;
		assertEquals(10L, new SuffixDecomposition().findTotalFun(P, A0, X, Y, B0, X1, Y1, N));
	}
}
