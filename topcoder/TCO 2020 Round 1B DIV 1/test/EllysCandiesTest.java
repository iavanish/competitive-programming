import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EllysCandiesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] boxes = new int[] {4, 2};
		assertEquals("Kris", new EllysCandies().getWinner(boxes));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] boxes = new int[] {1, 1, 1000};
		assertEquals("Elly", new EllysCandies().getWinner(boxes));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] boxes = new int[] {42, 42, 42, 42, 42, 42, 42, 42};
		assertEquals("Kris", new EllysCandies().getWinner(boxes));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] boxes = new int[] {42, 13, 17, 666, 55, 100, 3, 20, 81, 42, 123};
		assertEquals("Elly", new EllysCandies().getWinner(boxes));
	}
}
