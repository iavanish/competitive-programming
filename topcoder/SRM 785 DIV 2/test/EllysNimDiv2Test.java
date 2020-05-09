import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EllysNimDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] A = new int[] {42, 13, 123, 55, 666, 17};
		assertEquals(480, new EllysNimDiv2().getMin(A));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] A = new int[] {1, 1};
		assertEquals(0, new EllysNimDiv2().getMin(A));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] A = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		assertEquals(4, new EllysNimDiv2().getMin(A));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] A = new int[] {371, 740, 211, 798, 82, 385, 979, 389, 31, 667, 541, 561, 471};
		assertEquals(42, new EllysNimDiv2().getMin(A));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] A = new int[] {769, 727, 657, 924, 879, 674, 652, 995, 947, 896, 869, 553, 954, 974, 681, 768, 913};
		assertEquals(666, new EllysNimDiv2().getMin(A));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] A = new int[] {543, 230, 421, 415, 271, 962, 677, 373, 951, 114, 379, 15, 211, 955,
 66,  573, 982, 296, 730, 591, 750, 877, 224, 186, 398, 84, 542, 770,
 288, 78,  373, 417, 476, 968, 564, 565, 740, 377, 633, 287, 111, 823};
		assertEquals(44, new EllysNimDiv2().getMin(A));
	}
}
