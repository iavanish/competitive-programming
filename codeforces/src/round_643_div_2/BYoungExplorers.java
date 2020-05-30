package round_643_div_2;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class BYoungExplorers {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] e = new int[n];
            for (int i = 0; i < n; i++) {
                e[i] = in.nextInt();
            }
            Arrays.sort(e);

            int groups = 0;
            for (int i = 0; i < n; i++) {
                int size = e[i];
                int j = i;
                while (j < n-1 && size > (j - i + 1)) {
                    j++;
                    size = e[j];
                }
                if (size <= (j - i + 1)) {
                    groups++;
                }
                i = j;
            }

            out.println(groups);
        }
    }

}
