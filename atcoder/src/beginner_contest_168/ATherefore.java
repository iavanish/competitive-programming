package beginner_contest_168;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class ATherefore {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int r = n % 10;
        if (Arrays.asList(2, 4, 5, 7, 9).contains(r)) {
            out.println("hon");
        }
        else if (Arrays.asList(0, 1, 6, 8).contains(r)) {
            out.println("pon");
        }
        else {
            out.println("bon");
        }
    }

}
