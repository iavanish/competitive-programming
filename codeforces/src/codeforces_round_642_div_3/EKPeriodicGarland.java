package codeforces_round_642_div_3;

import commons.FastReader;

import java.io.PrintWriter;

public class EKPeriodicGarland {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            if (s.indexOf('1') < 0) {
                out.println(0);
            }
            else {
                s = s.substring(s.indexOf('1'));
                if (s.lastIndexOf('1') == 0) {
                    out.println(0);
                }
                else {
                    s = s.substring(0, s.lastIndexOf('1') + 1);
                    n = s.length();
                    char[] c = new char[n];
                    for (int i = 0; i < n; i++) {
                        if (i % k == 0) {
                            c[i] = '1';
                        }
                        else {
                            c[i] = '0';
                        }
                    }
                    int[] a = new int[n];
                    for (int i = 1; i < s.length(); i++) {
                        a[i] = a[i-1];
                        if (s.charAt(i) != c[i]) {
                            a[i]++;
                        }
                    }

                    int result = a[n-1];
                    int tillNow1 = 1;
                    for (int i = 1; i < n; i++) {
                        result = Math.min(result, tillNow1 + a[n-1] - a[i-1]);
                        if (s.charAt(i) == '1') {
                            tillNow1++;
                        }
                    }

                    out.println(result);
                }
            }

        }
    }

}
