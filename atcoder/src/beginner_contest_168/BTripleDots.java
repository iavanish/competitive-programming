package beginner_contest_168;

import commons.FastReader;

import java.io.PrintWriter;

public class BTripleDots {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int k = in.nextInt();
        String s = in.next().trim();
        while (s.isEmpty()) {
            s = in.next().trim();
        }

        if (s.length() <= k) {
            out.println(s);
        }
        else {
            out.println(s.substring(0, k) + "...");
        }
    }

}
