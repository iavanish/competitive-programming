package round_644_div_3;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class BHonestCoach {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    min = Math.min(min, Math.abs(s[i] - s[j]));
                }
            }
            out.println(min);
        }
    }

}
