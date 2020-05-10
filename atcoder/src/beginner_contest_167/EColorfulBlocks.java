package beginner_contest_167;

import commons.FastReader;

import java.io.PrintWriter;

public class EColorfulBlocks {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        // ToDo
        long mod = 998244353;

        int n = in.nextInt();
        long m = in.nextLong();
        int k = in.nextInt();

        long[] pow = new long[n + 1];
        pow[0] = 1L;
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * m;
            pow[i] %= mod;
        }

        if (k == n - 1) {
            out.println(pow[n]);
        } else {
            long result = mod(pow[n] - pow[n - k - 2], mod);
            out.println(result);
        }
    }

    private long mod(long n, long mod) {
        if (n >= 0) {
            return n % mod;
        }
        n = -n;
        if (n % mod == 0) {
            return 0;
        }
        long div = n / mod;
        div++;
        return (mod * div) - n;
    }

}
