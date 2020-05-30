import org.junit.Test;
import static org.junit.Assert.*;

public class SmallestRegularTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "(())";
		assertArrayEquals(new int[] { }, new SmallestRegular().findLexSmallest(S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "(()())";
		assertArrayEquals(new int[] {1, 2, 3 }, new SmallestRegular().findLexSmallest(S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "";
		for (int i = 0; i < 250; i++) {
			S = S + "()";
		}
		assertArrayEquals(new int[] {2, 3, 6, 2, 3, 5, 0, 1, 4 }, new SmallestRegular().findLexSmallest(S));
	}
}
