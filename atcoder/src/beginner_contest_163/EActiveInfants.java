package beginner_contest_163;

import commons.FastReader;

import java.io.PrintWriter;

public class EActiveInfants {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int x = 0;
        int y = n-1;
        int happiness = 0;
        while (x <= y) {
            int firstMax = -1;
            int firstMaxIndex = -1;
            int lastMax = -1;
            int lastMaxIndex = -1;
            for (int i = 0; i < n; i++) {
                if (firstMax < a[i]) {
                    firstMax = a[i];
                    firstMaxIndex = i;
                }
                if (lastMax <= a[i]) {
                    lastMax = a[i];
                    lastMaxIndex = i;
                }
            }

            if (Math.abs(y - lastMaxIndex) < Math.abs(x - firstMaxIndex)) {
                a[firstMaxIndex] = -1;
                happiness += (firstMax * Math.abs(x - firstMaxIndex));
                x++;
            }
            else {
                a[lastMaxIndex] = -1;
                happiness += (lastMax * Math.abs(y - lastMaxIndex));
                y--;
            }
        }

        out.println(happiness);
    }

}
