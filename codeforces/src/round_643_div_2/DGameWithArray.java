package round_643_div_2;

import commons.FastReader;

import java.io.PrintWriter;

public class DGameWithArray {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int s = in.nextInt();

        if (n - 1 < s - n) {
            out.println("YES");
            for (int i = 0; i < n - 1; i++) {
                out.printf("%d ", 1);
            }
            out.printf("%d\n%d", (s - n + 1), n);
        }
        else {
            out.println("NO");
        }
    }

}
