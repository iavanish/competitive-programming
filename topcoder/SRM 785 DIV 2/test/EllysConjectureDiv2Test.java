import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EllysConjectureDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int L = 13;
		int R = 17;
		assertEquals(22L, new EllysConjectureDiv2().getSum(L, R));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int L = 42;
		int R = 1337;
		assertEquals(6048L, new EllysConjectureDiv2().getSum(L, R));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int L = 12345;
		int R = 67890;
		assertEquals(259216L, new EllysConjectureDiv2().getSum(L, R));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int L = 42666;
		int R = 133742;
		assertEquals(425026L, new EllysConjectureDiv2().getSum(L, R));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int L = 123456789;
		int R = 987654321;
		assertEquals(4032921822L, new EllysConjectureDiv2().getSum(L, R));
	}
}
