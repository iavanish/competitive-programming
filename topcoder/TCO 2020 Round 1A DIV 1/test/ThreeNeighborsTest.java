import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ThreeNeighborsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 2;
		assertArrayEquals(new String[] {".....", ".XX..", ".X.X.", ".X...", "....." }, new ThreeNeighbors().construct(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 6;
		assertArrayEquals(new String[] {"........", ".XXX..X.", "..X..X..", "..X..X..", "..X...X.", "........" }, new ThreeNeighbors().construct(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 1;
		assertArrayEquals(new String[] {"XXXX", "XXXX", ".XXX" }, new ThreeNeighbors().construct(N));
	}
}
