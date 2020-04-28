import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumBalancesTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "((((";
		assertEquals(0, new MaximumBalances().solve(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "(())";
		assertEquals(3, new MaximumBalances().solve(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = ")))())";
		assertEquals(1, new MaximumBalances().solve(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "))()()))(()";
		assertEquals(10, new MaximumBalances().solve(s));
	}
}
