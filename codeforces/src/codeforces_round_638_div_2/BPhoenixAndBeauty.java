package codeforces_round_638_div_2;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BPhoenixAndBeauty {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }

            if (set.size() > k) {
                out.println(-1);
                continue;
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            List<Integer> result = new ArrayList<>();
            for (int i = 1; k * i <= n * n; i++) {
                for (int j = 0; j < Math.max(k, list.size()); j++) {
                    if (j < list.size()) {
                        result.add(list.get(j));
                    }
                    else {
                        result.add(list.get(list.size()-1));
                    }
                }
            }

            out.println(result.size());
            for (Integer i : result) {
                out.printf("%d ", i);
            }
            out.println();
        }
    }

}
