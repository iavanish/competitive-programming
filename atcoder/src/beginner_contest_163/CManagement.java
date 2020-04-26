package beginner_contest_163;

import commons.FastReader;

import java.io.PrintWriter;

public class CManagement {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] countSubordinates = new int[n];
        for (int i = 1; i < n; i++) {
            countSubordinates[in.nextInt()-1]++;
        }

        for (int i : countSubordinates) {
            out.println(i);
        }
    }

}
