package beginner_contest_167;

import commons.FastReader;

import java.io.PrintWriter;

public class CSkillUp {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] cost = new int[n];
        int[][] value = new int[n][m];
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextInt();
            for (int j = 0; j < m; j++) {
                value[i][j] = in.nextInt();
            }
        }

        long result = solve(cost, value, new int[m], 0, x);
        if (result == Integer.MAX_VALUE) {
            out.println(-1);
        }
        else {
            out.println(result);
        }
    }

    private long solve(int[] cost, int[][] value, int[] accumulatedValue, int currBook, int x) {
        if (currBook == cost.length) {
            if (accumulated(accumulatedValue, x)) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        long result = solve(cost, value, accumulatedValue, currBook + 1, x);
        for (int i = 0; i < accumulatedValue.length; i++) {
            accumulatedValue[i] += value[currBook][i];
        }
        result = Math.min(result, cost[currBook] + solve(cost, value, accumulatedValue, currBook + 1, x));
        for (int i = 0; i < accumulatedValue.length; i++) {
            accumulatedValue[i] -= value[currBook][i];
        }
        return result;
    }

    private boolean accumulated(int[] accumulatedValue, int x) {
        for (int a : accumulatedValue) {
            if (a < x) {
                return false;
            }
        }
        return true;
    }

}
