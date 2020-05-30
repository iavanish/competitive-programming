package round_644_div_3;

import commons.FastReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSimilarPairs {

    public void solve(int testNumber, FastReader in, PrintWriter out) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            List<Integer> evenNumbers = new ArrayList<>();
            List<Integer> oddNumbers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                if (temp % 2 == 0) {
                    evenNumbers.add(temp);
                }
                else {
                    oddNumbers.add(temp);
                }
            }

            if (evenNumbers.size() % 2 == 0 && oddNumbers.size() % 2 == 0) {
                out.println("YES");
                continue;
            }

            boolean flag = false;
            Set<Integer> oddNumbersSet = new HashSet<>(oddNumbers);
            for (Integer i : evenNumbers) {
                if (oddNumbersSet.contains(i-1) || oddNumbersSet.contains(i+1)) {
                    flag = true;
                    break;
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
