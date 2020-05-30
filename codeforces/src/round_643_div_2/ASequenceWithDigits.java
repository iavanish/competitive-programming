package round_643_div_2;

import commons.FastReader;

import java.io.PrintWriter;

public class ASequenceWithDigits {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            long a = in.nextLong();
            long k = in.nextLong();

            for (long i = 1; i < k; i++) {
                long temp = a;
                long min = Long.MAX_VALUE;
                long max = Long.MIN_VALUE;
                while (temp > 0) {
                    long r = temp % 10;
                    min = Math.min(min, r);
                    max = Math.max(max, r);
                    temp /= 10;
                }
                if (min == 0 || max == 0) {
                    break;
                }
                a += (min * max);
            }
            out.println(a);
        }
    }

}
