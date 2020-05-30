package codeforces_round_642_div_3;

import commons.FastReader;

import java.io.PrintWriter;

public class CBoardMoves {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();

            long sum = 0;
            for (long i = 1, j = 8; i <= n / 2; i++, j += 8) {
                sum += (i * j);
            }

            out.println(sum);
        }
    }

}
