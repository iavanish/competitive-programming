import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EllysPalMulDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int X = 42;
		assertEquals(6, new EllysPalMulDiv2().getMin(X));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int X = 121;
		assertEquals(1, new EllysPalMulDiv2().getMin(X));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int X = 1337;
		assertEquals(143, new EllysPalMulDiv2().getMin(X));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int X = 13;
		assertEquals(38, new EllysPalMulDiv2().getMin(X));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int X = 100;
		assertEquals(-1, new EllysPalMulDiv2().getMin(X));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int X = 39325;
		assertEquals(-1, new EllysPalMulDiv2().getMin(X));
	}
}
