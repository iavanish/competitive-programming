package beginner_contest_168;

import commons.FastReader;

import java.io.PrintWriter;

public class CColon {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int h = in.nextInt();
        int m = in.nextInt();

        double angle = angle(h, m);
        double cSquare = Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(Math.toRadians(angle));
        out.println(Math.sqrt(cSquare));
    }

    private double angle(int h, int m) {
        if (h == 12) {
            h = 0;
        }
        if (m == 60) {
            m = 0;
        }
        double hourAngle = (0.5 * (h * 60 + m));
        double minuteAngle = 6 * m;

        double angle = Math.abs(hourAngle - minuteAngle);
        return Math.min(angle, 360 - angle);
    }

}
