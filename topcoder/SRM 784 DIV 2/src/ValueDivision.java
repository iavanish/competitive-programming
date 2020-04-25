public class ValueDivision {

	public int[] getArray(int[] A) {
		int n = A.length;

		int lastMax = Integer.MAX_VALUE;
		while (true) {
			int newMax = 1;
			int newMaxIndex = 1;
			for (int i = 0; i < n; i++) {
				if (A[i] >= newMax && A[i] < lastMax) {
					newMax = A[i];
					newMaxIndex = i;
				}
			}
			if (newMax == 1) {
				break;
			}
			for (int i = 0; i < newMaxIndex; i++) {
				if (A[i] == newMax) {
					A[i]--;
				}
			}
			lastMax = newMax;
		}

		return A;
	}

}
