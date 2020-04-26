package educational_round_86;

import commons.FastReader;

import java.io.PrintWriter;

public class ARoadToZero {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long x = in.nextLong();
            long y = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();

            if (x > y) {
                long temp = x;
                x = y;
                y = temp;
            }

            long ans = (y - x) * a;
            b = Math.min(b, a * 2);
            ans += x * b;

            out.println(ans);
        }
    }

}
