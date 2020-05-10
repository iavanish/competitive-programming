package beginner_contest_167;

import commons.FastReader;

import java.io.PrintWriter;

public class DTeleporter {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int n = in.nextInt();
        long k = in.nextLong();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        boolean[] isVisited = new boolean[n + 1];
        int curr = 1;
        while (!isVisited[curr]) {
            isVisited[curr] = true;
            curr = a[curr];
        }

        int distanceToCurr = 0;
        int temp = 1;
        while (temp != curr) {
            distanceToCurr++;
            temp = a[temp];
        }

        int revisitCurr = 1;
        temp = a[curr];
        while (temp != curr) {
            revisitCurr++;
            temp = a[temp];
        }

        if (k <= distanceToCurr) {
            temp = 1;
            while (k-- > 0) {
                temp = a[temp];
            }
            out.println(temp);
        } else {
            k -= distanceToCurr;
            k %= revisitCurr;
            temp = curr;
            while (k-- > 0) {
                temp = a[temp];
            }
            out.println(temp);
        }
    }

}
