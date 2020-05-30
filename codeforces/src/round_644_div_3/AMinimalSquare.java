package round_644_div_3;

import commons.FastReader;

import java.io.PrintWriter;

public class AMinimalSquare {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int side = Math.max(2 * b, a);
            out.println(side * side);
        }
    }

}
