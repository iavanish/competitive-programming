package beginner_contest_167;

import commons.FastReader;

import java.io.PrintWriter;

public class BEasyLinearProgramming {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        in.nextLong();
        long k = in.nextLong();

        long sum = Math.min(a, k);
        k -= (a + b);
        sum -= Math.max(0, k);

        out.println(sum);
    }

}
