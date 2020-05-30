package round_644_div_3;

import commons.FastReader;

import java.io.PrintWriter;

public class DBuyingShovels {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();

            if (n <= k) {
                out.println(1);
                continue;
            }

            long smallestFactor = n;
            for (long i = 2; i <= Math.min(k, Math.sqrt(n)); i++) {
                if (n % i == 0) {
                    long factor = n / i;
                    if (factor <= k) {
                        factor = Math.min(factor, i);
                    }
                    smallestFactor = Math.min(smallestFactor, factor);
                }
            }

            out.println(smallestFactor);
        }
    }

}
