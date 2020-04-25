import org.junit.Test;
import static org.junit.Assert.*;

public class ScissorsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		assertEquals(20, new Scissors().openingTime(N));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 10;
		assertEquals(40, new Scissors().openingTime(N));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 1234;
		assertEquals(110, new Scissors().openingTime(N));
	}
}
