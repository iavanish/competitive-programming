package beginner_contest_163;

import commons.FastReader;

import java.io.PrintWriter;

public class ACirclePond {

    private static final double pie = 3.14159265358979323846;

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        double r = in.nextInt();
        out.println(2.0 * pie * r);
    }

}
