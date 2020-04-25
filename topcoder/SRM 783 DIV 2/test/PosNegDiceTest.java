import org.junit.Test;
import static org.junit.Assert.*;

public class PosNegDiceTest {
	
	@Test(timeout=2000)
	public void test0() {
		int T = 1;
		int[] positiveDice = new int[] {1, 6, 2};
		int[] negativeDice = new int[] {6};
		assertArrayEquals(new int[] {1, 0 }, new PosNegDice().evaluateRoll(T, positiveDice, negativeDice));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int T = 4;
		int[] positiveDice = new int[] {};
		int[] negativeDice = new int[] {};
		assertArrayEquals(new int[] {0, 0 }, new PosNegDice().evaluateRoll(T, positiveDice, negativeDice));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int T = 4;
		int[] positiveDice = new int[] {5, 6, 6, 5, 5};
		int[] negativeDice = new int[] {};
		assertArrayEquals(new int[] {0, 0 }, new PosNegDice().evaluateRoll(T, positiveDice, negativeDice));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int T = 5;
		int[] positiveDice = new int[] {3, 6, 3, 6};
		int[] negativeDice = new int[] {3, 3, 1, 3, 6, 3, 5};
		assertArrayEquals(new int[] {0, 4 }, new PosNegDice().evaluateRoll(T, positiveDice, negativeDice));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int T = 4;
		int[] positiveDice = new int[] {4, 5, 6};
		int[] negativeDice = new int[] {1, 2, 3};
		assertArrayEquals(new int[] {1, 3 }, new PosNegDice().evaluateRoll(T, positiveDice, negativeDice));
	}
}
