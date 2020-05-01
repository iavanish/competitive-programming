import org.junit.Test;
import static org.junit.Assert.*;

public class EllysDifferentPrimesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 100;
		assertEquals(97, new EllysDifferentPrimes().getClosest(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 123457;
		assertEquals(123457, new EllysDifferentPrimes().getClosest(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 6661337;
		assertEquals(6701459, new EllysDifferentPrimes().getClosest(N));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 42424242;
		assertEquals(42398701, new EllysDifferentPrimes().getClosest(N));
	}
}
