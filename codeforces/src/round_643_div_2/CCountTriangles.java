package round_643_div_2;

import commons.FastReader;

import java.io.PrintWriter;

public class CCountTriangles {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        long sum = 0;
        for (int i = a; i <= b; i++) {
            sum += sum(Math.min(i + c, d + 1) - c);
        }

        out.println(sum);
    }

    private int sum(int n) {
        return (n * (n + 1)) / 2;
    }

}
