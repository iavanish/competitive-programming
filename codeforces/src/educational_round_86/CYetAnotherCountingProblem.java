package educational_round_86;

import commons.FastReader;

import java.io.PrintWriter;

public class CYetAnotherCountingProblem {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long q = in.nextLong();

            StringBuilder result = new StringBuilder();

            long lcm = (a * b) / gcd(a, b);
            while (q-- > 0) {
                long l = in.nextLong();
                long r = in.nextLong();
                l = Math.max(l, Math.max(a, b));
                if (r < l) {
                    result.append(0 + " ");
                }
                else {
                    long countL = (l - 1) / lcm;
                    long countR = (r-Math.max(a,b)) / lcm;
                    long temp = (r - l + 1) - ((countR - countL) * (Math.max(a, b)));
                    if (temp == 0) {
                        result.append("0 ");
                    }
                    else {
                        result.append(temp);
                        result.append(" ");
                    }
                }
            }

            out.println(result.toString());
        }
    }

    private long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a-b, b);
        }
        return gcd(a, b-a);
    }

}
