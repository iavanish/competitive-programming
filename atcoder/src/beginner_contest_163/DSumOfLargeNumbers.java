package beginner_contest_163;

import commons.FastReader;

import java.io.PrintWriter;

public class DSumOfLargeNumbers {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        long mod = 1000000007;
        long n = in.nextLong();
        long k = in.nextLong();

        long sum = 0;
        for (long i = k; i <= n; i++) {
            long start = sum(i-1);
            long end = sum(n) - sum(n-i);
            sum += (end - start + 1);
            sum %= mod;
        }

        out.println(sum+1);
    }

    private long sum(long n) {
        return (n * (n+1)) / 2;
    }

}
