import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CutTheCubeTest {
	
	@Test(timeout=2000)
	public void test0() {
		Random random = new Random();
		CutTheCube cutTheCube = new CutTheCube();
		int L = 0, R = 0, H = 0;
		int i = 1;
		for (; i < 10000000; i++) {
			L = random.nextInt(100000) + 1;
			R = random.nextInt(100000) + 1;
			H = random.nextInt(100000) + 1;
			if (cutTheCube.findWinner(L, R, H) != cutTheCube.findWinner1(L, R, H)) {
				break;
			}
		}
		assertEquals(1, new CutTheCube().findWinner(0, 0, 0));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int L = 4647;
		int B = 34061;
		int H = 5356;
		assertEquals(1, new CutTheCube().findWinner(L, B, H));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int L = 2;
		int B = 2;
		int H = 1;
		assertEquals(1, new CutTheCube().findWinner(L, B, H));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int L = 97931;
		int B = 95210;
		int H = 92383;
		assertEquals(1, new CutTheCube().findWinner(L, B, H));
	}
}
