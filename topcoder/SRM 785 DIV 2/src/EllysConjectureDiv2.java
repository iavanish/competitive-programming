public class EllysConjectureDiv2 {

	public long getSum(int L, int R) {
		long sum = 0;
		if (L == 1) {
			sum += 1;
		}
		if (L <= 2 && R >= 2) {
			sum += 2;
		}
		if (L <= 3 && R >= 3) {
			sum += 3;
		}

		L = Math.max(4, L);
		if (R < L) {
			return sum;
		}
		L -= 3;
		L--;
		R -= 3;

		return sum + sum(R) - sum(L);
	}

	private long sum(long total) {
		long remainder = total / 3;
		long sum = remainder * 14;
		total %= 3;
		if (total == 1) {
			sum += 4;
		}
		if (total == 2) {
			sum += 8;
		}
		return sum;
	}

}
