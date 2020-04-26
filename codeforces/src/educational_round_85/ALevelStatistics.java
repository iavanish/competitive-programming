package educational_round_85;

import commons.FastReader;

import java.io.PrintWriter;

public class ALevelStatistics {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            int c = in.nextInt();
            boolean success = (c <= p);

            for (int i = 1; i < n; i++) {
                int tempP = in.nextInt();
                int tempC = in.nextInt();
                if (tempP < p || tempC < c || ((tempP - p) < (tempC - c))) {
                    success = false;
                }
                p = tempP;
                c = tempC;
            }

            out.println(success ? "YES" : "NO");
        }
    }

}
