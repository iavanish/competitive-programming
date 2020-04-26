package educational_round_86;

import commons.FastReader;

import java.io.PrintWriter;

public class BBinaryPeriod {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next().trim();
            while (s.isEmpty()) {
                s = in.next().trim();
            }

            int zero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }
            if (zero == 0 || zero == s.length()) {
                out.println(s);
                continue;
            }

            StringBuilder result = new StringBuilder();
            boolean lastWas0 = true;
            for (int i = 0; i < 2 * s.length(); i++) {
                result.append(lastWas0 ? "1" : "0");
                lastWas0 = !lastWas0;
            }

            out.println(result.toString());
        }
    }

}
