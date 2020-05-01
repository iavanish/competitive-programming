package codeforces_round_638_div_2;

import commons.FastReader;

import java.io.PrintWriter;

public class APhoenixAndBalance {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            long sum1 = 0;
            long sum2 = 0;
            long two = 2;
            int i = 1;
            for (; i < (n/2); i++, two*=2) {
                sum1 += two;
            }
            for (; i < n; i++, two*=2) {
                sum2 += two;
            }

            sum1 += two;

            out.println(sum1 - sum2);
        }
    }

}
