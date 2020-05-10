package beginner_contest_167;

import commons.FastReader;

import java.io.PrintWriter;

public class ARegistration {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        String s = in.next().trim();
        while (s.isEmpty()) {
            s = in.next().trim();
        }
        String t = in.next().trim();
        while (t.isEmpty()) {
            t = in.next().trim();
        }

        if (s.equals(t.substring(0, t.length() - 1))) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }

}
