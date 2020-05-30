package codeforces_round_642_div_3;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class BTwoArraysAndSwaps {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            k = Math.min(k, n);

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0, j = n-1; k > 0; i++, j--, k--) {
                if (a[i] > b[j]) {
                    break;
                }
                a[i] = b[j];
            }

            int sum = 0;
            for (int i : a) {
                sum += i;
            }

            out.println(sum);
        }
    }

}
