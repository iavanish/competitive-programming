import org.junit.Test;
import static org.junit.Assert.*;

public class ValueDivisionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] A = new int[] {1, 5, 7, 4, 5, 4, 1};
		assertArrayEquals(new int[] {1, 2, 7, 3, 5, 4, 1 }, new ValueDivision().getArray(A));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] A = new int[] {7};
		assertArrayEquals(new int[] {7 }, new ValueDivision().getArray(A));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] A = new int[] {7, 4};
		assertArrayEquals(new int[] {7, 4 }, new ValueDivision().getArray(A));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] A = new int[] {7, 7, 7, 7};
		assertArrayEquals(new int[] {4, 5, 6, 7 }, new ValueDivision().getArray(A));
	}
}
