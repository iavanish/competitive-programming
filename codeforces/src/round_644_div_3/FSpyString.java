package round_644_div_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class FSpyString {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.next();
            }

            if (m == 1 || n == 1) {
                out.println(a[0]);
                continue;
            }

            if (n == 2) {
                StringBuilder result = new StringBuilder();
                int firstTaken = 0;
                for (int i = 0; i < m; i++) {
                    if (a[0].charAt(i) == a[1].charAt(i)) {
                        result.append(a[0].charAt(i));
                    }
                    else {
                        if (firstTaken == 0) {
                            result.append(a[0].charAt(i));
                        }
                        else {
                            result.append(a[1].charAt(i));
                        }
                        firstTaken++;
                    }
                }
                if (firstTaken <= 1) {
                    out.println(result.toString());
                }
                else {
                    out.println(-1);
                }
                continue;
            }

            boolean[] isVisited = new boolean[n];
            List<String> s = new ArrayList<>();
            boolean flag = true;
            while (true) {
                int x = -1;
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (!isVisited[i]) {
                        boolean lFlag = true;
                        int lCount = 0;
                        for (int j = 0; j < n; j++) {
                            if (i == j || isVisited[j]) {
                                continue;
                            }
                            int diff = difference(a[i], a[j]);
                            if (diff <= 1) {
                                lCount++;
                            }
                            else {
                                lFlag = false;
                            }
                        }
                        if (lFlag && count < lCount) {
                            x = i;
                            count = lCount;
                        }
                    }
                }
                if (count == 0) {
                    flag = false;
                    break;
                }
                s.add(a[x]);
                visit(a, x, isVisited);
            }

            flag = true;
            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    flag = false;
                }
            }

            if (!flag || s.size() > 2) {
                out.println(-1);
                continue;
            }

            if (s.size() == 1) {
                out.println(s.get(0));
                continue;
            }

            StringBuilder result = new StringBuilder();
            int firstTaken = 0;
            for (int i = 0; i < m; i++) {
                if (s.get(0).charAt(i) == s.get(1).charAt(i)) {
                    result.append(s.get(0).charAt(i));
                }
                else {
                    if (firstTaken == 0) {
                        result.append(s.get(0).charAt(i));
                    }
                    else {
                        result.append(s.get(1).charAt(i));
                    }
                    firstTaken++;
                }
            }

            if (firstTaken <= 1) {
                out.println(result.toString());
            } else {
                out.println(-1);
            }
        }
    }

    private void visit(String[] a, int i, boolean[] isVisited) {
        isVisited[i] = true;
        for (int j = 0; j < a.length; j++) {
            if (i == j || isVisited[j]) {
                continue;
            }
            if (difference(a[i], a[j]) <= 1) {
                isVisited[j] = true;
            }
        }
    }

    private int difference(String s, String s1) {
        int difference = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s1.charAt(i)) {
                difference++;
            }
        }
        return difference;
    }

}
