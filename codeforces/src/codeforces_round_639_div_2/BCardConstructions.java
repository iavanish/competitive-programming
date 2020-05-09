package codeforces_round_639_div_2;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class BCardConstructions {

    private long[] sums;

    private void populateSums() {
        sums = new long[1000000];
        sums[0] = 2;
        long diff = 5;
        for (int i = 1; i < 1000000; i++) {
            sums[i] = sums[i - 1] + diff;
            diff += 3;
        }
    }

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        populateSums();

        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            int max = 0;
            while (n > 0) {
                int index = Arrays.binarySearch(sums, n);
                if (index < 0) {
                    index = -index;
                    index -= 2;
                    if (index < 0) {
                        break;
                    }
                }
                max++;
                n -= sums[index];
            }

            out.printf("%d\n", max);
        }
    }

}
