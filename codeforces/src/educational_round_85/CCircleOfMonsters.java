package educational_round_85;

import commons.FastReader;

import java.io.PrintWriter;

public class CCircleOfMonsters {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n*2];
            long[] b = new long[n*2];
            for (int i = 0; i < n; i++) {
                a[i] = a[i+n] = in.nextLong();
                b[i] = b[i+n] = in.nextLong();
            }

            long tempMin = a[0];
            for (int i = 1; i < n; i++) {
                tempMin += Math.max(0, a[i]-b[i-1]);
            }
            long minBullet = tempMin;

            for (int i = 1, j = n; j < n*2; i++, j++) {
                tempMin -= a[i-1];
                tempMin -= Math.max(0, a[i]-b[i-1]);
                tempMin += a[i];
                tempMin += Math.max(0, a[j]-b[j-1]);
                minBullet = Math.min(minBullet, tempMin);
            }

            out.println(minBullet);
        }
    }

}
