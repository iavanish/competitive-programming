import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AveragePriceTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] prices = new int[] { 10, 20, 10 };
		assertEquals(15.0, new AveragePrice().nonDuplicatedAverage(prices), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] prices = new int[] { 1, 2, 3, 4, 5 };
		assertEquals(3.0, new AveragePrice().nonDuplicatedAverage(prices), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] prices = new int[] { 10, 10, 10, 10, 10, 10 };
		assertEquals(10.0, new AveragePrice().nonDuplicatedAverage(prices), 1e-9);
	}
}
