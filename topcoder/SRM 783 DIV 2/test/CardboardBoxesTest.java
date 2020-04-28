import org.junit.Test;

import static org.junit.Assert.*;

public class CardboardBoxesTest {
	
	@Test(timeout=2000)
	public void test0() {
		long S = 47L;
		assertEquals(0L, new CardboardBoxes().count(S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long S = 470L;
		assertEquals(6L, new CardboardBoxes().count(S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long S = 4700L;
		assertEquals(106L, new CardboardBoxes().count(S));
	}

	@Test(timeout=2000)
	public void test3() {
		long S = 8L;
		assertEquals(1L, new CardboardBoxes().count(S));
	}
}
