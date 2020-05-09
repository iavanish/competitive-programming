import java.util.Arrays;

public class EllysNimDiv2 {

	public int getMin(int[] A) {
		int[][] dp = new int[A.length][2048];
		for (int i = 0; i < A.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return getMin(A, dp, 0, 0);
	}

	private int getMin(int[] A, int[][] dp, int currI, int currXor) {
		if (currI == A.length) {
			return currXor == 0 ? 0 : 100000;
		}
		if (dp[currI][currXor] != -1) {
			return dp[currI][currXor];
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= 1024; i++) {
			result = Math.min(result, i + getMin(A, dp, currI+1, currXor ^ (A[currI] + i)));
		}
		dp[currI][currXor] = result;
		return result;
	}

}
