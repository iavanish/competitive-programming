import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EllysWhatDidYouGetTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 9;
		assertEquals(952, new EllysWhatDidYouGet().getCount(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 5;
		assertEquals(3515, new EllysWhatDidYouGet().getCount(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 13;
		assertEquals(456, new EllysWhatDidYouGet().getCount(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 42;
		assertEquals(149, new EllysWhatDidYouGet().getCount(N));
	}
}
