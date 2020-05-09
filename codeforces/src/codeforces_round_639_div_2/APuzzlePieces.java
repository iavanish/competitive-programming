package codeforces_round_639_div_2;

import commons.FastReader;

import java.io.PrintWriter;

public class APuzzlePieces {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            if (m == 1 || n == 1 || (m == 2 && n == 2)) {
                out.printf("YES\n");
            } else {
                out.printf("NO\n");
            }
        }
    }

}
