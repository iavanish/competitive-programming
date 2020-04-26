package beginner_contest_163;

import commons.FastReader;

import java.io.PrintWriter;

public class BHomework {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            n -= in.nextInt();
        }

        out.println(0 <= n ? n : -1);
    }

}
