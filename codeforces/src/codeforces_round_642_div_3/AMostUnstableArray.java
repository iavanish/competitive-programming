package codeforces_round_642_div_3;

import commons.FastReader;

import java.io.PrintWriter;

public class AMostUnstableArray {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();
            long m = in.nextLong();

            if (n == 1) {
                out.println(0);
            }
            else if (n == 2) {
                out.println(m);
            }
            else {
                out.println(m * 2);
            }
        }
    }

}
