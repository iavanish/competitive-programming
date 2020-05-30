package round_644_div_3;

import java.util.Scanner;
import java.io.PrintWriter;

public class EPolygon {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                grid[i] = s.toCharArray();
            }

            boolean flag = true;
            outer: for (int i = n - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    if (grid[i][j] == '1') {
                        if (grid[i + 1][j] != '1' && grid[i][j + 1] != '1') {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }

            if (flag) {
                out.println("YES");
            }
            else {
                out.println("NO");
            }
        }
    }

}
