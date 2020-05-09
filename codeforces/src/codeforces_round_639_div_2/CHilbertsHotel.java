package codeforces_round_639_div_2;

import commons.FastReader;

import java.io.PrintWriter;

public class CHilbertsHotel {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] countGuests = new int[n];

            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int index = mod(a, n);
                index = (i + index) % n;
                countGuests[index]++;
            }

            boolean flag = true;
            for (int c : countGuests) {
                if (c > 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                out.printf("YES\n");
            } else {
                out.printf("NO\n");
            }
        }
    }

    private int mod(int a, int n) {
        if (a >= 0) {
            return a % n;
        }
        int temp = -a;
        int div = temp / n;
        if (temp % n != 0) {
            div++;
        }
        return a + (n * div);
    }

}
