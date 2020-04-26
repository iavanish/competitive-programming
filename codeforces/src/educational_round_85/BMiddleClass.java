package educational_round_85;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BMiddleClass {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            long x = in.nextLong();

            List<Long> a = new ArrayList<>();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                long temp = in.nextLong();
                sum += temp;
                if (temp < x) {
                    a.add(temp);
                }
            }

            Collections.sort(a);
            int i = 0;
            while (i < a.size() && (sum / n) < x) {
                sum -= a.get(i++);
                n--;
            }

            out.println(n);
        }
    }

}
