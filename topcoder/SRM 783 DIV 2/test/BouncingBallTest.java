import org.junit.Test;

import static org.junit.Assert.*;

public class BouncingBallTest {
	
	@Test(timeout=2000)
	public void test0() {
		int g = 981;
		int h = 10;
		int p = 0;
		int t = 1;
		assertEquals(5.095, new BouncingBall().getPosition(g, h, p, t), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int g = 981;
		int h = 10;
		int p = 0;
		int t = 2;
		assertEquals(6.408564143658009, new BouncingBall().getPosition(g, h, p, t), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int g = 981;
		int h = 10;
		int p = 0;
		int t = 47;
		assertEquals(1.5951180154118365, new BouncingBall().getPosition(g, h, p, t), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int g = 981;
		int h = 10;
		int p = 8;
		int t = 2;
		assertEquals(6.081311391188509, new BouncingBall().getPosition(g, h, p, t), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int g = 981;
		int h = 10;
		int p = 8;
		int t = 47;
		assertEquals(0.7952075484286876, new BouncingBall().getPosition(g, h, p, t), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test5() {
		int g = 1000;
		int h = 10;
		int p = 10;
		int t = 50;
		assertEquals(0.036079462357220954, new BouncingBall().getPosition(g, h, p, t), 1e-9);
	}
}
