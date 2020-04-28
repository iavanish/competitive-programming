import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlindBoxSetsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int numSets = 1;
		int numItems = 1;
		assertEquals(1.0, new BlindBoxSets().expectedPurchases(numSets, numItems), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int numSets = 1;
		int numItems = 2;
		assertEquals(3.0, new BlindBoxSets().expectedPurchases(numSets, numItems), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int numSets = 2;
		int numItems = 1;
		assertEquals(2.0, new BlindBoxSets().expectedPurchases(numSets, numItems), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int numSets = 2;
		int numItems = 2;
		assertEquals(5.5, new BlindBoxSets().expectedPurchases(numSets, numItems), 1e-9);
	}
}
